object Solution {
    def longestPalindromeSubseq(s: String): Int = {
        if (s.isEmpty) return 0
        var dp2 = Array.fill(s.length)(0)
        var dp1 = Array.fill(s.length)(1)
        for (L <- 2 to s.length) {
            val dp = dp2
            for (i<- 0 to s.length - L) {
                dp(i) = 
                    if (s(i) == s(i+L-1)) dp2(i+1) + 2
                    else dp1(i).max(dp1(i+1))
            }
            dp2 = dp1
            dp1 = dp
            //println(dp.mkString(","))
        }
        dp1(0)
    }
}