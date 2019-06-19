object Solution {
    val M = 1000
    def findTargetSumWays(nums: Array[Int], S: Int): Int = {
        if (S< -M || S> M) return 0
        var dp = new Array[Int](M*2+1)
        dp(M) = 1
        for (n<-nums) {
            val dp2 = new Array[Int](M*2+1)
            for (i<- -M to M) {
                if (i-n >= -M) dp2(i+M) += dp(i-n+M) 
                if (i+n <= M) dp2(i+M) += dp(i+n+M)
            }
            dp = dp2
        }
        dp(S+M)
    }
}