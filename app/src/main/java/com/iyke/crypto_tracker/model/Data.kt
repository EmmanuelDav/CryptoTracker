package com.iyke.crypto_tracker.model

import com.iyke.crypto_tracker.R

object Data {
    var list = arrayListOf<PortfolioCoins>(
        PortfolioCoins("Bitcoin","$19000","+4%", R.drawable.bbtc,"USD","BTC"),
        PortfolioCoins("Etherium","$1000","+2%", R.drawable.eth,"USD","Eth"),
        PortfolioCoins("Tether","$1","+5%", R.drawable.tether,"USD","USDT"),
        PortfolioCoins("USD Coin","$1","+0.01%", R.drawable.usdc,"USD","USDC"),
        PortfolioCoins("BNB","$225","+4.19%", R.drawable.bnb,"USD","BNB"),
    )
}