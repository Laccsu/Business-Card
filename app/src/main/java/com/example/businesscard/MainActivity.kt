package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Profile(
            fullName = stringResource(R.string.fullName),
            title = stringResource(R.string.title)
        )
        Contacts()
    }
}

@Composable
private fun Profile(fullName: String, title: String, modifier: Modifier = Modifier) {
    val imageProfile = painterResource(R.drawable.luccas)
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = imageProfile,
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth(0.6F)
                .padding(bottom = 8.dp)
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            color = Color.White
        )
        Text(
            text = title,
            fontWeight = FontWeight.Light,
            fontSize = 22.sp,
            color = Color.White
        )
    }
}

@Composable
private fun Contacts() {
    val phoneIconImage = painterResource(R.drawable.icons8_phone_96___)
    val shareIconImage = painterResource(R.drawable.icons8_github_200___)
    val mailIconImage = painterResource(R.drawable.icons8_mail_96___)

    Column(
        Modifier.fillMaxWidth().padding(top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Image(
                painter = phoneIconImage,
                contentDescription = null,
                modifier = Modifier.size(28.dp).padding(4.dp)
            )
            Text(
                text = "+55 (11) 97825-6267",
                color = Color.White
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            Image(
                painter = shareIconImage,
                contentDescription = null,
                modifier = Modifier.size(28.dp).padding(4.dp)
            )
            Text(
                text = "Laccsu",
                color = Color.White
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(4.dp)) {
            Image(
                painter = mailIconImage,
                contentDescription = null,
                modifier = Modifier.size(28.dp).padding(4.dp)
            )
            Text(
                text = "lopesluccassilva@gmail.com",
                color = Color.White
            )
        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
