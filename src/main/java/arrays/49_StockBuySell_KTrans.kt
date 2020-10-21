package arrays

class StockBuySell_KTrans {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("** output "+ maxProfit2(2, intArrayOf(1,2,4)))
            println("** output "+ maxProfitWithAtMost2Transactions(intArrayOf(1,2,4)))
        }
    }
}


fun maxProfitWithAtMost2Transactions(prices: IntArray): Int {
    if(prices.size <= 1) return 0
    // we will start from right to left, and see the max profit if we buy at this point and afterwards and attains max profit
    val dpBuyHereOrLaterAndSellAfterWards = Array(prices.size) {0}
    var maxAtThisPoint = prices[prices.size - 1]
    var maxProfitIfBuyNowAndSellLater = 0
    for(i in prices.size-2 downTo 0) {
        if(prices[i] > maxAtThisPoint) {
            maxAtThisPoint = prices[i]
        }
        maxProfitIfBuyNowAndSellLater = maxAtThisPoint - prices[i]
        if(maxProfitIfBuyNowAndSellLater > dpBuyHereOrLaterAndSellAfterWards[i + 1]) {
            dpBuyHereOrLaterAndSellAfterWards[i] = maxProfitIfBuyNowAndSellLater
        } else {
            dpBuyHereOrLaterAndSellAfterWards[i] = dpBuyHereOrLaterAndSellAfterWards[i + 1]
        }
    }

    // we will start from left to right, and see the max profit if we sell at this point or before and attains max profit
    val dpSellHereOrBefore = Array(prices.size) {0}
    var minAtThisPoint = prices[0]
    var maxProfitIfSellHereOrBefore = 0
    for(i in 1 until prices.size) {
        if(prices[i] < minAtThisPoint) {
            minAtThisPoint = prices[i]
        }
        maxProfitIfSellHereOrBefore = prices[i] - minAtThisPoint
        if(maxProfitIfSellHereOrBefore > dpSellHereOrBefore[i -1]) {
            dpSellHereOrBefore[i] = maxProfitIfSellHereOrBefore
        } else {
            dpSellHereOrBefore[i] = dpSellHereOrBefore[i - 1]
        }
    }

    var maxResult = 0
    for(i in dpSellHereOrBefore.indices) {
        maxResult = Math.max(maxResult, dpSellHereOrBefore[i] + dpBuyHereOrLaterAndSellAfterWards[i])
    }
    return maxResult
}

fun maxProfitWithAsManyTransactions(prices: IntArray): Int {
    if (prices.size == 0) return 0
    var profit = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1]
    }
    return profit
}

fun maxProfitWithAsSingleTransaction(prices: IntArray): Int {
    if (prices.size == 0) return 0
    var minShareValue = prices[0]
    var maxProfit = 0
    for (i in 1 until prices.size) {
        minShareValue = Math.min(minShareValue, prices[i])
        maxProfit = Math.max(maxProfit, prices[i] - minShareValue)
    }
    return maxProfit
}

fun maxProfit(k: Int, prices: IntArray): Int {
    if(prices.size <= 1) return 0
    val profit = Array(k + 1) {Array(prices.size) {0} }
    for(t in 1 .. k) {
        var maxProfit = Integer.MIN_VALUE
        for (i in 1 until prices.size) {
            maxProfit = Math.max(maxProfit, (profit[t-1][i-1] - prices[i -1]))
            profit[t][i] = Math.max(profit[t][i -1], prices[i] + maxProfit)
        }
    }
    return profit[k][prices.size -1]
}

fun maxProfit2(k: Int, prices: IntArray): Int {
    if(prices.size == 0) return 0
    if(k >= prices.size / 2) {
        var profit = 0
        for(i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1]
        }
        return profit
    }
    val evenProfit = Array(prices.size) {0}
    val oddProfit = Array(prices.size) {0}
    for(t in 1 .. k) {
        var maxThusFar = Integer.MIN_VALUE
        var currentProfit:Array<Int>? = null
        var previousProfit:Array<Int>? = null
        if(t % 2 == 1 )  {
            currentProfit = oddProfit
            previousProfit = evenProfit
        } else {
            currentProfit = evenProfit
            previousProfit = oddProfit
        }
        for (i in 1 until prices.size) {
            maxThusFar = Math.max(maxThusFar, (previousProfit[i-1] - prices[i -1]))
            currentProfit[i] = Math.max(currentProfit[i -1], prices[i] + maxThusFar)
        }
    }
    return if(k % 2 == 0) evenProfit[prices.size -1] else oddProfit[prices.size - 1]
}