// peek
// dp(i,j) = sum_{x=a,b,c,d} dp(i,j,x)
// dp(i,j,x) = if S(i)!=x   dp(i+1,j,x)
//             if S(j)!=x   dp(i,j+1,x)
//             else         dp(i+1,j-1) + 2  
// dp(i,i,x) = 0
// dp(i, i+1, x) = if S(i) = X 1 else 0

//  x, xx, plus xTx for T in dp(i+1,j-1).
//  dp(i+1,j-1, x) don't need to be counted again, because
//  if xUx is in dp(i+1,j-1,x), then U is in dp(i+1,j-1) thus xUx
//  is already counted.

object Solution {
    val M = 1000000007
    def countPalindromicSubsequences(S: String): Int = {
        var dp0 = Array.fill(S.length, 4)(0L)
        var dp1 = Array.fill(S.length, 4)(0L)
        for (i<- S.indices) dp1(i)(S(i)-'a') = 1
        var dp = Array.ofDim[Long](S.length, 4)
        for (L <- 2 to S.length) {
            for (i<-0 to S.length - L) {
                val j = i + L - 1
                val c1 = S(i) - 'a'
                val c2 = S(j) - 'a'
                for (x<-0 until 4) {
                    dp(i)(x) =
                        if (c1 != x) dp1(i+1)(x)
                        else if (c2 != x) dp1(i)(x)
                        else (dp0(i+1)(0)+dp0(i+1)(1)
                              +dp0(i+1)(2)+dp0(i+1)(3)+2) % M
                }
            }
            val t = dp0; dp0=dp1;dp1=dp; dp=t
        }
        ((dp1(0)(0)+dp1(0)(1)+dp1(0)(2)+dp1(0)(3)) % M).toInt
    }
}