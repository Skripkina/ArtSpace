package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                ) {
                    ArtPage(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun ArtPage(modifier: Modifier = Modifier) {

    var currentImage by remember { mutableStateOf(1) }

    var imageResource = painterResource(R.drawable.img1)
    var nameResource = stringResource(R.string.name1)

    when(currentImage) {
        1 -> { imageResource = painterResource(R.drawable.img1)
            nameResource = stringResource(R.string.name1)}
        2 -> { imageResource = painterResource(R.drawable.img2)
            nameResource = stringResource(R.string.name2)}
        3 -> { imageResource = painterResource(R.drawable.img3)
            nameResource = stringResource(R.string.name3)}
        4 -> { imageResource = painterResource(R.drawable.img4)
            nameResource = stringResource(R.string.name4)}
        5 -> { imageResource = painterResource(R.drawable.img5)
            nameResource = stringResource(R.string.name5)}
        else -> {
            currentImage = 1
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = imageResource,
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .shadow(5.dp, clip = true)
                .padding(40.dp)
        )

        Column (
            modifier
                .fillMaxWidth()
                .padding(20.dp)
                .shadow(8.dp)
                .background(Color(0xFFE0E0E0))
                .padding(15.dp)

        ){
            Text(
                text = nameResource,
                fontSize = 28.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .align(alignment = Alignment.Start)
            )

            Row (
            ){
                Text(
                    text = stringResource(R.string.autor1),
                    fontSize = 16.sp,
                    fontWeight= FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = stringResource(R.string.date1),
                    modifier = Modifier
                )
            }
        }
    }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom,
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 20.dp)

        ) {
            Button(
                modifier = Modifier.size(120.dp, 40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF757575)
                ),
                onClick = {
                    if (currentImage == 1) {
                        currentImage = 5
                    } else  { currentImage--}
                }) {
                Text("Previous")
            }

            Button(
                modifier = Modifier.size(120.dp, 40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF757575)
                ),
                onClick = { currentImage++ }) {
                Text("Next")
            }
        }
}


/*@Composable
fun ChangeImage(currentImage:Int) {
    val imageResource: Painter
    val nameResource: String

    when(currentImage) {
        1 -> { imageResource = painterResource(R.drawable.img1)
               nameResource = stringResource(R.string.name)}
        2 -> { imageResource = painterResource(R.drawable.img2)
               nameResource = stringResource(R.string.name)}
    }
}*/



@Preview(showBackground = true)
@Composable
fun ArtPagePreview() {
    ArtSpaceTheme {
        ArtPage()
    }
}