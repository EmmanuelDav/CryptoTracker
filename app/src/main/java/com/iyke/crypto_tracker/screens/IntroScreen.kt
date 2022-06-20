package com.iyke.crypto_tracker.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.common.CommonText
import com.iyke.crypto_tracker.ui.theme.LightGrayColor

@Composable
fun IntroScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = "The World Fastest Crypto Growing App",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Grow your portfolio by receiving rewards on your crypto growing asset!",
            fontSize = 18.sp,
            color = LightGrayColor,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(10.dp))
    }

}