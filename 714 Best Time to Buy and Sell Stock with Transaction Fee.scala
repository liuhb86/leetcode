object Solution {
    def maxProfit(prices: Array[Int], fee: Int): Int = {
        if (prices.isEmpty) return 0
        var r = 0
        var minp = prices.head
        var lastSale = -1
        for (i<-1 until prices.length) {
            val p = prices(i)
            var profit = p - minp - fee
            if (lastSale >=0) {
                profit = profit.max(p-lastSale)
            }
            if (profit > 0) {
                r += profit
                lastSale = p
                minp = p
            } else if (p < minp) {
                minp = p
            }
        }
        r
    }
}