package com.iyke.crypto_tracker.screens

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iyke.crypto_tracker.MainScreenView
import com.iyke.crypto_tracker.ui.theme.Typography
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.common.CryptoSelection
import com.iyke.crypto_tracker.common.CurrencyItem
import com.iyke.crypto_tracker.common.SetPriceAlertSection
import com.iyke.crypto_tracker.common.ValuesItem
import com.iyke.crypto_tracker.model.Constants
import com.iyke.crypto_tracker.model.Data.list
import com.iyke.crypto_tracker.model.PortfolioCoins
import com.iyke.crypto_tracker.ui.theme.Black
import com.iyke.crypto_tracker.ui.theme.Green



class CryptoDetailScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoDetailScreen("bnb")
        }
    }
}

@Composable
fun CryptoDetailScreen(
    currencyCode: String,

    ) {
    val currency = list.find { it.coinShotName == currencyCode}!!

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Black
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 50.dp)
        ) {
            // TopNavigationRow(onBackArrowPressed = onBackArrowPressed)

            LineChartCardSection(currency = currency)


            CurrencyDescriptionCard(currency = currency)

            SetPriceAlertSection()
        }
    }
}

@Composable
private fun CurrencyDescriptionCard(currency: PortfolioCoins) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.PADDING_SIDE_VALUE.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = Constants.ELEVATION_VALUE.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Constants.PADDING_SIDE_VALUE.dp)
        ) {
            Text(
                text = "About ${currency.coinName}",
                style = Typography.h2
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "${currency.currentPrice}",
                style = Typography.subtitle2
            )
        }
    }
}

@Composable
private fun BuyCryptoCard(
    currency: PortfolioCoins,
    onButtonClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(Constants.PADDING_SIDE_VALUE.dp)
            .fillMaxWidth(),
        elevation = Constants.ELEVATION_VALUE.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Column() {
            CurrencyInfoBuyRow(currency = currency)

            StandardButton(
                onButtonClick = onButtonClick,
                currency = currency,
                buttonText = "Buy"
            )
        }
    }
}

@Composable
fun StandardButton(
    onButtonClick: (String) -> Unit,
    currency: PortfolioCoins,
    buttonText: String
) {
    Button(
        onClick = {
            onButtonClick(currency.coinShotName)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Green
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.PADDING_SIDE_VALUE.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = buttonText,
            color = Color.White
        )
    }
}

@Composable
private fun CurrencyInfoBuyRow(currency: PortfolioCoins) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.PADDING_SIDE_VALUE.dp)
    ) {
        CurrencyItem(currency = currency)

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "",
                    style = Typography.h2,
                )

                Text(
                    text = "",
                    style = Typography.subtitle2,
                    color = Black
                )
            }

            Image(
                painter = painterResource(id = R.drawable.right_arrow),
                contentDescription = null,
                modifier = Modifier
                    .clipToBounds()
                    .padding(start = (Constants.PADDING_SIDE_VALUE * 1.5).dp)
            )
        }
    }
}

@Composable
private fun LineChartCardSection(currency: PortfolioCoins) {
    Card(
        modifier = Modifier
            .padding(Constants.PADDING_SIDE_VALUE.dp)
            .fillMaxWidth(),
        elevation = Constants.ELEVATION_VALUE.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CardCurrencyInfoSection(currency = currency)

//                    Insert line chart later
            Image(
                painter = painterResource(id = R.drawable.sample_line_chart_image),
                contentDescription = "Line chart image",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
private fun CardCurrencyInfoSection(
    currency: PortfolioCoins
) {
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(Constants.PADDING_SIDE_VALUE.dp)
        ) {
            CurrencyItem(currency = currency)

            Column() {
                ValuesItem(
                    currency = currency,
                    priceModifier = Modifier,
                    currencyPriceStyle = Typography.h2
                )
            }
        }
    }
}

@Composable
fun TopNavigationRow(
    onBackArrowPressed: () -> Unit,
    isStarNeeded: Boolean = true
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .padding(
                top = (Constants.ELEVATION_VALUE + Constants.PADDING_SIDE_VALUE).dp,
                start = (2 * Constants.ELEVATION_VALUE).dp,
                end = Constants.PADDING_SIDE_VALUE.dp
            )
            .fillMaxWidth()
    ) {
        BackRowItem(onBackArrowPressed = onBackArrowPressed)

        FavouritesStarItem(isStarNeeded)
    }
}

@Composable
private fun FavouritesStarItem(
    isStarNeeded: Boolean = true
) {
    if (isStarNeeded) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "favourites start",
                modifier = Modifier
                    .size(25.dp)
            )
        }
    }
}

@Composable
private fun BackRowItem(onBackArrowPressed: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Go back",
            modifier = Modifier
                .size(25.dp)
                .clickable {
                    onBackArrowPressed()
                }
        )

        Text(
            text = "Back",
            modifier = Modifier
                .padding(start = 8.dp),
            style = Typography.h2
        )
    }
}

@Preview
@Composable
fun CyptoDetailScreenPreview() {
    CryptoDetailScreen(
        currencyCode = "ETH",
    )
}