package com.iyke.crypto_tracker.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iyke.crypto_tracker.R

// Set of Material typography styles to start with


val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.main)),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.sub)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

)