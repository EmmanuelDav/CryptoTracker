package com.iyke.crypto_tracker.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.MainActivity
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.common.ListColumn
import com.iyke.crypto_tracker.common.ListRowItem
import com.iyke.crypto_tracker.model.Constants.Companion.SHOTNAME
import com.iyke.crypto_tracker.model.Data.list
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
            .verticalScroll(rememberScrollState())
            .wrapContentSize(Alignment.TopStart)
            .padding(5.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Total balance",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                )

                Text(
                    text = "2000.09 USD",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.subtitle1

                )
            }

            Column(
                Modifier.padding(10.dp)
            ) {

                Text(
                    text = "+18.9%",
                    fontWeight = FontWeight.Bold,
                    color = Color.Green,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(2.dp)

                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "$43.340",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(2.dp),
                            style = MaterialTheme.typography.subtitle1

                )
            }

        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {

            Box {
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
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.body1

                    )
                }
            }

            Box {
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
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.body1

                    )
                }
            }

            Box {
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
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.body1

                    )

                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "  Portfolio", fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                style = MaterialTheme.typography.subtitle1

            )
            Text(
                "See all", fontWeight = FontWeight.Bold,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                style = MaterialTheme.typography.subtitle2

            )
        }
        val context = LocalContext.current
        LazyRow(modifier = Modifier.fillMaxWidth(1F)) {
            items(items = list) { item ->
                ListRowItem(item){
                    val intent = Intent(context, CryptoDetailScreen::class.java)
                    intent.putExtra(SHOTNAME,item.currencyCode)
                    context.startActivity(intent)
                }
            }
        }

        Text(
            "Market trend", fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Start,
            fontSize = 15.sp,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(10.dp)
        )

        list.forEachIndexed { index, portfolioCoins ->
            ListColumn(item = portfolioCoins)
        }
        Spacer(modifier = Modifier.height(120.dp))
    }
}