package com.iyke.crypto_tracker.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.iyke.crypto_tracker.model.Constants

class TransactionDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current

            val intent = (context as TransactionDetails).intent

            val shotName = intent.getStringExtra(Constants.SHOTNAME)

        }
    }
}