package com.iyke.crypto_tracker.model

import com.iyke.crypto_tracker.R

object Data {
    var list = arrayListOf<PortfolioCoins>(
        PortfolioCoins("Bitcoin","$19000.0","+4%", R.drawable.bbtc,"USD","BTC"),
        PortfolioCoins("Ethereum","$1000.0","+2%", R.drawable.eth,"USD","Eth"),
        PortfolioCoins("Tether","$1.00","+5%", R.drawable.tether,"USD","USDT"),
        PortfolioCoins("USD Coin","$1.00","+0.01%", R.drawable.usdc,"USD","USDC"),
        PortfolioCoins("BNB","$225.0","+4.19%", R.drawable.bnb,"USD","BNB"),
    )
}