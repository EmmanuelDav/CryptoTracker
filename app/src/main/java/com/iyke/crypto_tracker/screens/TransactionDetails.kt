package com.iyke.crypto_tracker.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.model.Constants
import com.iyke.crypto_tracker.model.Data
import com.iyke.crypto_tracker.model.Data.transactionList
import com.iyke.crypto_tracker.model.Transaction
import com.iyke.crypto_tracker.ui.theme.Black
import com.iyke.crypto_tracker.ui.theme.CryptoTrackerTheme
import com.iyke.crypto_tracker.ui.theme.White

class TransactionDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            val intent = (context as TransactionDetails).intent

            val id = intent.getIntExtra(Constants.Id,0)

            Transactions(id,
                onBackArrowPressed = {
            finish()
            },
                onButtonClick = {

                })
        }
    }
}

@Composable
fun Transactions(
    id :Int,
    onBackArrowPressed: () -> Unit,
    onButtonClick: (String) -> Unit
) {
    val currency = transactionList.find { it.transactionID == id }!!


    Column(
        modifier = Modifier
            .background(color = Black)
            .fillMaxSize()
            .wrapContentSize(Alignment.TopCenter)
            .padding(20.dp)
    ) {
        TopNavigationRow(onBackArrowPressed = onBackArrowPressed)

        Spacer(modifier = Modifier.height(40.dp))

        Column {
            Image(
                painter = painterResource(id = currency.Icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(15.dp).size(60.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Constants.PADDING_SIDE_VALUE.dp)
                    .background(color = White)
            )

            Text(
                text = currency.currencyCode ,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.body1
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Constants.PADDING_SIDE_VALUE.dp)
                    .background(color = White)
            )
        }
        ItemDescription(tittle = "Amount", text = currency.amount.toString())
        Spacer(modifier = Modifier.height(10.dp))
        ItemDescription(tittle = "TimeStamp", text = currency.transactionDate)
        Spacer(modifier = Modifier.height(10.dp))

        ItemDescription(tittle = "Type", text = currency.transactionType)
        Spacer(modifier = Modifier.height(10.dp))

        ItemDescription(tittle = "Description", text = currency.description)
    }
}

@Composable
private fun ItemDescription(
    tittle: String,
    text: String
) {
    Column(
        modifier = Modifier.padding()
    ) {
        Text(
            text = tittle,
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.White,
                lineHeight = 22.sp,

                ),
        )

        Spacer(modifier = Modifier.width(Constants.ELEVATION_VALUE.dp))

        Text(
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.White,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Bold,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun View() {
    CryptoTrackerTheme {
        Transactions(2,  onBackArrowPressed = {

        },
            onButtonClick = {

            })
    }
}
