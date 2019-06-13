object Solution {
    def numSquares(n: Int): Int = {
        val dp = (0 to n).toArray
        var s = 4
        var k = 5
        while(s<=n) {
            for (i<-s to n) {
                dp(i) = dp(i).min(dp(i-s)+1)
            }
            s+=k
            k+=2
        }
        dp(n)
    }
}