package com.iyke.crypto_tracker.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.google.accompanist.pager.pagerTabIndicatorOffset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.model.Constants
import com.iyke.crypto_tracker.ui.theme.Typography
import com.iyke.crypto_tracker.model.Data.list
import com.iyke.crypto_tracker.model.PortfolioCoins
import com.iyke.crypto_tracker.ui.theme.*
import kotlinx.coroutines.launch


@Composable
fun CommonText(
    text: String,
    color: Color = Color.Black,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    function: () -> Unit
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        modifier = Modifier.clickable {
            function()
        }
    )
}

@Composable
fun ValuesItem(
    currency: PortfolioCoins,
    priceModifier: Modifier = Modifier
        .padding(top = 20.dp),
    changesModifier: Modifier = Modifier
        .padding(top = 5.dp),
    currencyPriceStyle: TextStyle = Typography.h3,
    currencyChangesStyle: TextStyle = Typography.h3
) {
    var changeColor by remember {
        mutableStateOf(
            if(currency.changeType == "I") {
                Green
            } else {
                Red
            }
        )
    }

    var changeOperator by remember {
        mutableStateOf(
            if(currency.changeType == "I") {
                "+"
            } else {
                "-"
            }
        )
    }

    Text(
        text = "£${currency.currentPrice}",
        style = currencyPriceStyle,
        modifier = priceModifier
    )

    Text(
        text = "$changeOperator${currency}%",
        style = currencyChangesStyle,
        color = changeColor,
        modifier = changesModifier
    )
}


@Composable
fun SetPriceAlertSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Constants.PADDING_SIDE_VALUE.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = Constants.ELEVATION_VALUE.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(Constants.PADDING_SIDE_VALUE.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.notification_color),
                contentDescription = "Price Alert Icon"
            )

            SetPriceAlertTextColumn()

            Image(
                painter = painterResource(id = R.drawable.right_arrow),
                contentDescription = null
            )
        }
    }
}

@Composable
fun SetPriceAlertTextColumn() {
    Column() {
        Text(
            text = "Set Price Alert",
            style = Typography.h3
        )
        Text(
            text = "Get notified when your coins are moving",
            style = Typography.subtitle2,
            color = Gray
        )
    }
}
@Composable
fun CommonLoginButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
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
        onClick = { onClick() },
        elevation = ButtonDefaults.elevation(0.dp, 0.dp)
    ) {
        Text(text = text, fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun CommonGoogleButton(
    text: String
) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp),
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(58.dp)
            .border(3.dp, Color.Black, RoundedCornerShape(25.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White, RoundedCornerShape(20.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Google Logo",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(18.dp))
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}

@Composable
fun CurrencyItem(
    currency: PortfolioCoins
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = currency.coinLogo),
            contentDescription = currency.coinName,
            modifier = Modifier
                .size(25.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = Constants.PADDING_SIDE_VALUE.dp)
        ) {
            Text(
                text = currency.coinName,
                style = Typography.h2,
                color = Color.Black
            )

            Text(
                text = currency.currencyCode,
                style = Typography.subtitle1,
                color = Gray
            )
        }
    }
}


@Composable
fun CommonTextField(
    text: String,
    placeholder: String,
    isPasswordTextField: Boolean,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onValueChange(it) },
        label = { Text(text = placeholder, color = LightGrayColor) },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = PinkColor,
            cursorColor = Color.Black
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (isPasswordTextField) PasswordVisualTransformation()
        else VisualTransformation.None
    )
}

@Composable
fun ListRowItem(item: PortfolioCoins, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color.Gray.copy(0.2f), blue.copy(0.1f)
                    )
                ),
                RoundedCornerShape(20.dp)
            )
            .padding(15.dp)
            .height(210.dp).clickable {onClick()}
    ) {
        Image(
            painter = painterResource(id = item.coinLogo),
            contentDescription = "user icon",
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.BottomStart)
                .padding(10.dp)
        )
        Image(
            painter = painterResource(id = item.chat),
            contentDescription = "user icon",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
                .padding(1.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp)
        ) {
            Text(
                text = item.coinName,
                color = Color.White,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.currencyCode,
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_up_24),
                contentDescription = "user icon",
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = item.todaysIncORDec,
                color = Color.Green,
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
        ) {
            Text(
                text = item.currency,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = item.currentPrice,
                color = Color.White,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
fun ListColumn(item: PortfolioCoins) {
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = item.coinLogo),
                    contentDescription = null,
                    modifier = Modifier
                        .border(2.dp, Color.Gray, CircleShape)
                        .padding(15.dp)// add a border (optional)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = item.currency,
                        color = Color.White,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = item.currencyCode,
                        color = Color.White,
                        fontSize = 13.sp,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = item.currentPrice,
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = item.todaysIncORDec,
                    color = Color.Green,
                    fontSize = 13.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }

    }
}

@Composable
fun ListColumn1(item: PortfolioCoins) {
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = item.coinLogo),
                    contentDescription = null,
                    modifier = Modifier
                        .border(2.dp, Color.Gray, CircleShape)
                        .padding(15.dp)// add a border (optional)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(Modifier.align(Alignment.CenterVertically)) {
                    Text(
                        text = item.currency,
                        color = Color.White,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = item.coinName,
                        color = Color.White,
                        fontSize = 13.sp,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = item.currentPrice,
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "${item.demoMoney}(${item.todaysIncORDec})",
                    color = Color.White,
                    fontSize = 13.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }

        Divider(color = Color.White, thickness = 0.9.dp, modifier = Modifier
            .padding(5.dp)
            .align(Alignment.BottomCenter))

    }
}


@Composable
fun CryptoSelection() {
    var coinName: String by remember { mutableStateOf(list[0].coinName) }
    var coinLogo: Int by remember { mutableStateOf(list[0].coinLogo) }
    var expanded by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
        Row(
            Modifier
                .clickable {
                    expanded = !expanded
                }
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) { // Anchor view

            Image(
                painter = painterResource(id = coinLogo),
                contentDescription = "user icon",
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = coinName,
                fontSize = 18.sp,
                color = White,
                modifier = Modifier.padding(end = 8.dp)
            ) // Country name label
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "",
                tint = Color.White
            )

            //
            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }) {
                list.forEach { country ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        coinName = country.coinName
                        coinLogo = country.coinLogo
                    }) {
                        Text(text = country.coinName)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CombinedTab() {
    val tabData = listOf(
        "Tokens",
        "Positions",
        "NFTs",
    )
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
        initialPage = 0,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(backgroundColor = Black,
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions), color = White
                )
            }
        ) {
            tabData.forEachIndexed { index, pair ->
                Tab(selected = tabIndex == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = pair)
                }, selectedContentColor = White)
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (index) {
                    0 -> {
                        LazyColumn(modifier = Modifier.fillMaxWidth(1F)) {
                            items(items = list) { item ->
                                ListColumn1(item)
                            }
                        }
                    }
                    1 -> {
                        empty("No opened positions Yet")
                    }
                    2 -> {
                        empty("No NFts yet")
                    }
                }
            }
        }
    }
}

@Composable
fun empty(text: String){
    Column {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_emoji_flags_24),
            tint = White,
            contentDescription = null,
            modifier = Modifier
                .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
                .padding(15.dp).align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.body1

        )
    }
}




