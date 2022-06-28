package com.iyke.crypto_tracker.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.common.TransactionItem
import com.iyke.crypto_tracker.model.Constants
import com.iyke.crypto_tracker.model.Data.transactionList
import com.iyke.crypto_tracker.ui.theme.Black
import com.iyke.crypto_tracker.ui.theme.Typography
import com.iyke.crypto_tracker.ui.theme.White

@Preview
@Composable
fun value() {
    Transaction()
}

@Composable
fun Transaction() {
    Surface(
        modifier = Modifier.fillMaxSize(), color = Black
    ) {
        Card(
            modifier = Modifier
                .padding(Constants.PADDING_SIDE_VALUE.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            backgroundColor = Color.Gray.copy(0.2f)
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        top = Constants.PADDING_SIDE_VALUE.dp,
                        start = Constants.PADDING_SIDE_VALUE.dp,
                        end = Constants.PADDING_SIDE_VALUE.dp
                    )
            ) {
                Text(
                    text = "Transaction History",
                    style = Typography.h2,
                    color = White
                )


                val context = LocalContext.current

                transactionList.forEachIndexed { index, transaction ->
                    TransactionItem(transaction) {
                        val intent = Intent(context, TransactionDetails::class.java)
                        intent.putExtra(Constants.SHOTNAME, transaction.transactionID)
                        context.startActivity(intent)
                    }
                    Divider(
                        modifier = Modifier
                            .padding(
                                top = Constants.PADDING_SIDE_VALUE.dp,
                                bottom = if (transactionList.size - 1 > index) {
                                    Constants.PADDING_SIDE_VALUE.dp
                                } else {
                                    0.dp
                                }
                            )
                    )
                }
            }
        }
    }
}