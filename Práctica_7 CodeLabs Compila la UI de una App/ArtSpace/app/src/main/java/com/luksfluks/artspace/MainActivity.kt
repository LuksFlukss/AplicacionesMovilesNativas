package com.luksfluks.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luksfluks.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val primeraImagen = R.drawable.pic1
    val segundaImagen = R.drawable.pic2
    val terceraImagen = R.drawable.pic3

    var title by remember {
        mutableStateOf(R.string.pic1)
    }
    var information by remember {
        mutableStateOf(R.string.pic1_info)
    }

    var currentArtwork by remember {
        mutableStateOf(primeraImagen)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "ArtSpace",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.gray_900)
            )
            ArtworkDisplay(currentArtwork = currentArtwork)
            Spacer(modifier = modifier.size(12.dp))
            ArtworkTitle(title = title, information = information)
            Spacer(modifier = modifier.size(25.dp))
            Row(
                modifier = modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                Button(
                    onClick = {
                        when (currentArtwork) {
                            primeraImagen -> {
                                currentArtwork = terceraImagen
                                title = R.string.pic3
                                information = R.string.pic3_info
                            }
                            segundaImagen -> {
                                currentArtwork = primeraImagen
                                title = R.string.pic1
                                information = R.string.pic1_info
                            }
                            terceraImagen -> {
                                currentArtwork = segundaImagen
                                title = R.string.pic2
                                information = R.string.pic2_info
                            }
                            else -> {
                                currentArtwork = terceraImagen
                                title = R.string.pic3
                                information = R.string.pic3_info
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.purple_500)
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 1.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "Anterior",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.black)
                    )
                }

                Button(
                    onClick = {
                        when (currentArtwork) {
                            primeraImagen -> {
                                currentArtwork = segundaImagen
                                title = R.string.pic2
                                information = R.string.pic2_info
                            }
                            segundaImagen -> {
                                currentArtwork = terceraImagen
                                title = R.string.pic3
                                information = R.string.pic3_info
                            }
                            else -> {
                                currentArtwork = primeraImagen
                                title = R.string.pic1
                                information = R.string.pic1_info
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.purple_200)
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 1.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "Siguiente",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.gray_900)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = 540.dp)
    )
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.pic2),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = 540.dp),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes information: Int
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.teal_200),
            fontSize = 24.sp
        )

        Text(
            text = stringResource(id = information),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}