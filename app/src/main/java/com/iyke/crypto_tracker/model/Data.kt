package com.iyke.crypto_tracker.model

import com.iyke.crypto_tracker.R

object Data {
    var list = arrayListOf<Portfolio_coins>(
        Portfolio_coins("Bitcoin","$19000","+4%", R.drawable.bbtc,"USD","BTC"),
        Portfolio_coins("Etherium","$1000","+2%", R.drawable.eth,"USD","Eth"),
        Portfolio_coins("Tether","$1","+5%", R.drawable.tether,"USD","USDT"),
        Portfolio_coins("USD Coin","$1","+0.01%", R.drawable.usdc,"USD","USDC"),
        Portfolio_coins("BNB","$225","+4.19%", R.drawable.bnb,"USD","BNB"),
    )
}