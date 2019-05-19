object Solution {
    def canPartition(nums: Array[Int]): Boolean = {
        val sum = nums.sum
        if (sum % 2 != 0 ) return false
        val half = sum / 2
        val dp = new Array[Array[Int]](nums.length + 1)
        dp(0) = Array.fill(half + 1)(0)
        for (i <- 1 to nums.length) {
            dp(i) = new Array[Int](half + 1)
            for (j <- 0 to half) {
                val v = nums(i - 1)
                if (v > j) dp(i)(j) = dp(i-1)(j)
                else dp(i)(j) = scala.math.max(dp(i-1)(j), dp(i-1)(j-v) + v)
            }
        }
        dp(nums.length)(half) == half
    }
}