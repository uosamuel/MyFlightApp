package com.example.flightapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import java.util.Random
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightapplication.PlaceDataList.placesList
import com.example.flightapplication.ui.theme.FlightApplicationTheme
import com.example.flightapplication.ui.theme.montFonts

class Destination : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            topRow(userImage = painterResource(id = R.drawable.plane))
        }
    }
}

val myfonts2 = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_black, FontWeight.Black),

    )


@Composable
fun placesCard() {
}

var list = listOf("All", "Flight", "Cruise", "Train", "Bike", "On Foot", "Bicycle")
val random: Double = 100 + Math.random() * (500 - 100)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun topRow(
    userImage: Painter,
) {
    var searchFieldlValue by remember {
        mutableStateOf("")
    }
    var rollScroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 20.dp)
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Where would you like to travel?",
                fontFamily = myfonts2,
                fontWeight = FontWeight.Bold,
                fontSize = 39.sp,
                maxLines = 2,
                modifier = Modifier.fillMaxWidth(.9f)
            )
            Image(
                painter = userImage,
                contentDescription = "user image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(50.dp)),
                contentScale = ContentScale.Crop,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = searchFieldlValue,
            onValueChange = { searchFieldlValue = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(10.dp)),
            label = {
                Text(
                    text = "Search",
                    color = Color(0xFF646464),
                    fontFamily = myfonts2,
                    fontWeight = FontWeight.Normal,
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color(0xFF646464),
                backgroundColor = Color(0xFFF1F1F1),
                disabledIndicatorColor = Color(0xFF646464),
                cursorColor = Color(0xFF646464),
                focusedIndicatorColor = Color(0x646464),
                focusedLabelColor = Color(0x646464),
                disabledLabelColor = Color(0x646464),
                unfocusedIndicatorColor = Color(0x646464),
            ),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = "search icon",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rollScroll)
        ) {

            list.forEach { listItem ->
                Text(
                    text = listItem,
                    fontSize = 20.sp,
                    fontFamily = myfonts2,
                    modifier = Modifier
                        .padding(start = 0.dp, end = 15.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xFFF1F1F1))
                        .padding(15.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        /*val numberOfItemsByRow =
        LocalConfiguration.current.screenWidthDp / 200 // you can replace 200 by the minimum size you want your cells to have.

        LazyColumn(modifier = Modifier) {

            items(placesList.chunked(numberOfItemsByRow)) { placesList ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    modifier = Modifier.padding(horizontal = 16.dp),
                ) {
                    for (place in placesList) {
                        PlaceCard(
                            card = place,
                            modifier = Modifier.weight(1F,)
                        )
                    }
                }
            }
        }*/

        /*LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 10.dp),
            content = {
                items(placesList.size){ index ->

                    PlaceCard(
                        card = placesList[index],
                        )

                }
            }
        )*/

        Column(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(rememberScrollState())
        ) {
            MyStaggeredGrid(
                numberOfColumn = 2,
                modifier = Modifier.padding(5.dp)
            ) {

                val randnum = Random()

                placesList.forEach { card ->

                    Surface(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(RoundedCornerShape(30.dp)),
                        elevation = 4.dp,) {
                        Box(
                            modifier = Modifier,
                            contentAlignment = Alignment.BottomStart
                        ) {
                           Image(
                                painter = painterResource(id = card.placeImage),
                                contentDescription = card.placeName,
                                contentScale = ContentScale.Crop,
                               modifier = Modifier.height(randnum.nextInt(200-500).dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = card.placeName,
                                    color = Color(0xFFFFFFFF),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    softWrap = true,
                                    modifier = Modifier.fillMaxWidth(.7f)
                                )
                                Text(
                                    text = "${card.placeCost}",
                                    color = Color(0xFF000000),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Normal,
                                    maxLines = 1,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(30.dp))
                                        .background(Color(0xFFFFFFFF))
                                        .padding(7.dp)
                                )
                            }
                        }
                    }

                }

                /*               items(placesList.size) { index ->

                                   PlaceCard(
                                       card = placesList[index],
                                   )

                               }*/
            }
        }
    }
}

data class CardData(
    var placeImage: Int,
    var placeName: String,
    var placeCost: Int,
    var height: Int,
)


@Composable
fun PlaceCard() {
    /*Column(
        modifier = Modifier
            .padding(5.dp)
            .verticalScroll(rememberScrollState())
    ) {
        MyStaggeredGrid(
            numberOfColumn = 2,
            modifier = Modifier.padding(5.dp)
        ) {
            placesList.forEach { card ->
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(30.dp)),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = card.placeImage),
                        contentDescription = card.placeName,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = card.placeName,
                            color = Color(0xFFFFFFFF),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            softWrap = true,
                            modifier = Modifier.fillMaxWidth(.7f)
                        )
                        Text(
                            text = "${card.placeCost}",
                            color = Color(0xFF000000),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 1,
                            modifier = Modifier
                                .clip(RoundedCornerShape(30.dp))
                                .background(Color(0xFFFFFFFF))
                                .padding(7.dp)
                        )
                    }
                }
            }

            *//*               items(placesList.size) { index ->

                               PlaceCard(
                                   card = placesList[index],
                               )

                           }*//*
        }
    }*/
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    topRow(userImage = painterResource(id = R.drawable.plane))
}