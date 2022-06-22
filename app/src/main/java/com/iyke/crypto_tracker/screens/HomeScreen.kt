package com.iyke.crypto_tracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.ui.theme.Black
import com.iyke.crypto_tracker.ui.theme.CryptoTrackerTheme


@Preview(showBackground = true)
@Composable
fun MyView() {
    CryptoTrackerTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(color = Black)
            .wrapContentSize(Alignment.TopStart)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                Text(
                    text = "Total balance",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )

                Text(
                    text = "     2000.09 USD",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(23.dp), horizontalAlignment = Alignment.End
            ) {

                Text(
                    text = "+18.9%",
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "$43.340",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
            }

        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {

            Box() {
                Column {

                    Image(
                        painter = painterResource(id = R.drawable.login),
                        contentDescription = null,
                        modifier = Modifier
                            .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                            .padding(15.dp)
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        text = "DEPOSIT",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                }

            }

            Box() {
                Column {

                    Image(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = null,
                        modifier = Modifier
                            .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                            .padding(15.dp)
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        text = "WITHDRAW",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                }


            }
            Box() {
                Column {

                    Image(
                        painter = painterResource(id = R.drawable.multiline),
                        contentDescription = null,
                        modifier = Modifier
                            .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                            .padding(15.dp)
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    Text(
                        text = "ANALYTICS",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                }
            }
        }

        Row( modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Start")
            Text("End")
        }

    }
}