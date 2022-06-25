package com.iyke.crypto_tracker.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.common.CryptoSelection
import com.iyke.crypto_tracker.ui.theme.Black



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
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Total Wallets",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Thin,
                color = Color.White,
                modifier = Modifier.wrapContentWidth().align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
            )

            CryptoSelection()
        }

    }
}
