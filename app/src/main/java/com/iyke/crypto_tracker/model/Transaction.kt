package com.iyke.crypto_tracker.model

data class Transaction(
    val transactionID: Int,
    val description: String,
    val amount: Float,
    val currencyCode: String,
    val transactionType: String,
    val transactionDate: String
)
