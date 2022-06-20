package com.iyke.crypto_tracker.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.ui.theme.LightGrayColor
import com.iyke.crypto_tracker.ui.theme.PinkColor
import com.iyke.crypto_tracker.ui.theme.blue

@Composable
fun IntroScreen() {
    Card(elevation = 4.dp) {
        Image(painter = painterResource(id = R.drawable.action), contentDescription = null, modifier = Modifier.fillMaxSize())
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(22.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = "The World Fastest Crypto Growing App",
                style = MaterialTheme.typography.body1,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Grow your portfolio by receiving rewards on your crypto growing asset!",
                fontSize = 18.sp,
                style = MaterialTheme.typography.body2,
                color = LightGrayColor,
                textAlign = TextAlign.Center

            )
            Spacer(modifier = Modifier.height(45.dp))
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Button(
                    modifier = Modifier
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    PinkColor, blue
                                )
                            ),
                            RoundedCornerShape(20.dp)
                        )
                        .height(58.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Transparent
                    ),
                    onClick = { },
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp)
                ) {
                    Text(text = "Get Started", fontSize = 20.sp, color = Color.White)
                }

            }

        }

    }
}