package com.example.mypresentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mypresentationcard.ui.theme.MyPresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPresentationCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage()
                    ProfileCard()
                }
            }
        }
    }
}

@Composable
fun GreetingImage() {
    // Create a Box to overlap the image and set a background color
    Box(
        modifier = Modifier
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
            .fillMaxSize()
    )
}

fun getRightPadding(): Dp {
    return 55.dp
}

@Composable
fun ProfileCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.image), // Reemplaza con tu imagen
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(150.dp)
                .background(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Louka Vanhoucke",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Presentation Card",
        )

        Spacer(modifier = Modifier.height(80.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = getRightPadding()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.correo),
                contentDescription = "Icon 3",
                modifier = Modifier.size(36.dp)
            )
            Text(text = "examplecorreo@gmail.com")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = getRightPadding()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.phone),
                contentDescription = "Icon 3",
                modifier = Modifier.size(36.dp)
            )
            Text(text = "+123456789")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = getRightPadding()),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "Icon 3",
                modifier = Modifier.size(36.dp)
            )
            Text(text = "@exampleUsuario")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardPreview() {
    MyPresentationCardTheme {
        GreetingImage()
        ProfileCard()
    }
}