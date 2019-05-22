import scala.math.max
object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        if (prices.isEmpty) return 0
        var s = 0
        var c = 0
        var b = 0
        for (i <- 1 until prices.length) {
            val d = prices(i) - prices(i - 1)
            val s2 = max(b + d, s)
            val c2 = s
            val b2 = max(b + d, c)
            s = s2
            c = c2
            b = b2  
        }
        s
    }
}