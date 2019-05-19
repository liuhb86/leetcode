import scala.math.max
object Solution {
    def lastStoneWeightII(stones: Array[Int]): Int = {
        val sum = stones.sum
        val half = sum / 2
        //println(s"$sum, $half")
        val dp = new Array[Array[Int]](stones.length + 1)
        dp(0) = Array.fill(half + 1)(0)
        for (i <- 1 to stones.length) {
            dp (i) = new Array(half + 1)
            val w = stones(i -1)
            for (j <- 0 to half) {
                if (j < w) dp(i)(j) = dp(i-1)(j)
                else dp(i)(j) = max(dp(i-1)(j), dp(i-1)(j-w) + w)
            }
        }
        val maxH = dp(stones.length)(half)
        //println(maxH)
        sum - maxH - maxH
    }
}