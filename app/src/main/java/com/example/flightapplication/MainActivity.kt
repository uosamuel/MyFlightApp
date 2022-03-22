package com.example.flightapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightapplication.ui.theme.FlightApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            topRow(userImage = painterResource(id = R.drawable.plane))
        }
    }
}


val myfonts = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_black, FontWeight.Black),
)

@Composable
fun PlaneScreen() {


    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.plane1),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            contentDescription = ""
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xD5160C00))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Travel with comfort and Safety!",
                modifier = Modifier,
                color = Color(0xFFFFFFFF),
                fontSize = 60.sp,
                fontFamily = myfonts,
                fontWeight = FontWeight.Black

            )
            Spacer(
                modifier = Modifier.height(40.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(Color(0xFFec6d67)),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "Sign up",
                    fontSize = 30.sp,
                    color = Color(0xFFFFFFFF)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaneScreen()
}