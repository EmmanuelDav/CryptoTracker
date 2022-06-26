package com.iyke.crypto_tracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.common.CombinedTab
import com.iyke.crypto_tracker.common.CryptoSelection
import com.iyke.crypto_tracker.ui.theme.*


@Preview(showBackground = true)
@Composable
fun WalletPreview() {
    WalletScreen()
}

@Composable
fun WalletScreen() {
    Column(
        modifier = Modifier
            .background(color = Black)
            .fillMaxHeight()
            .padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Total Wallets",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Thin,
                color = Color.White,
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
            )
            CryptoSelection()
        }

        Spacer(modifier = Modifier.height(25.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(color = Green, shape = RoundedCornerShape(15))
                .padding(25.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "023344.....33445",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier
                            .wrapContentWidth()
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                    )
                    Icon(
                        imageVector = Icons.Filled.List,
                        contentDescription = "",
                        tint = Color.White
                    )

                }

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "5,400.00",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier
                            .wrapContentWidth()
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                    )

                    Text(
                        text = "USD",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier
                            .wrapContentWidth()
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(7.dp)
                )

                Divider(color = Color.White, thickness = 2.dp)

                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.Bottom
                ) {

                    Box {
                        Column {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_call_received_24),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .background(
                                        Orange,
                                        CircleShape
                                    )   // add a border (optional)
                                    .padding(15.dp)
                            )
                            Spacer(modifier = Modifier.height(7.dp))

                            Text(
                                text = "Receive",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                style = MaterialTheme.typography.body1

                            )
                        }
                    }

                    Box {
                        Column {

                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = null,
                                modifier = Modifier
                                    .background(Color.Black, CircleShape)
                                    .padding(15.dp),
                                tint = Color.White

                                )
                            Spacer(modifier = Modifier.height(7.dp))

                            Text(
                                text = "Buy",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }

                    Box {
                        Column {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_baseline_call_made_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .background(
                                        blue,
                                        CircleShape
                                    )   // add a border (optional)
                                    .padding(15.dp),
                                tint = Color.White

                            )
                            Spacer(modifier = Modifier.height(7.dp))
                            Text(
                                text = "Send",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        CombinedTab()
    }
}
