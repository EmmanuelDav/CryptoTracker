package com.iyke.crypto_tracker.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R
import com.iyke.crypto_tracker.model.PortfolioCoins
import com.iyke.crypto_tracker.ui.theme.LightGrayColor
import com.iyke.crypto_tracker.ui.theme.PinkColor
import com.iyke.crypto_tracker.ui.theme.blue


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
fun ListRowItem(item: PortfolioCoins) {
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
            .height(210.dp)
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
            painter = painterResource(id = R.drawable.ic_baseline_show_chart_24),
            contentDescription = "user icon",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
                .padding(10.dp)
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
                text = item.coinShotName,
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
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Row(modifier = Modifier
                .padding(10.dp)){
                Image(
                    painter = painterResource(id = item.coinLogo),
                    contentDescription = null,
                    modifier = Modifier.border(2.dp, Color.Gray, CircleShape).padding(15.dp)// add a border (optional)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(Modifier.align(Alignment.CenterVertically)){
                    Text(
                        text = item.currency,
                        color = Color.White,
                        fontSize = 16.sp,
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = item.coinShotName,
                        color = Color.White,
                        fontSize = 13.sp,
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(10.dp).align(Alignment.CenterVertically)
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
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}


