package com.iyke.crypto_tracker.model

import com.iyke.crypto_tracker.R

object Data {
    var list = arrayListOf<PortfolioCoins>(
        PortfolioCoins("Bitcoin","$19000.0","+4%", R.drawable.bbtc,"USD","BTC","32,00",R.drawable.home_alk),
        PortfolioCoins("Ethereum","$1000.0","+2%", R.drawable.eth,"USD","Eth","25,00",R.drawable.home_ba),
        PortfolioCoins("Tether","$1.00","+5%", R.drawable.tether,"USD","USDT","0.01",R.drawable.home_ccl),
        PortfolioCoins("USD Coin","$1.00","+0.01%", R.drawable.usdc,"USD","USDC","76,00",R.drawable.home_dal),
        PortfolioCoins("BNB","$225.0","+4.19%", R.drawable.bnb,"USD","BNB","11,20",R.drawable.home_eadsy),
    )


}


class Constants {
    companion object {
        const val PADDING_SIDE_VALUE = 12
        const val ELEVATION_VALUE = 10
    }
}