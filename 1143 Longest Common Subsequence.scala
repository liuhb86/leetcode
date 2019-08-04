//dp(m,n) = dp(m-1, n-1) + 1 or dp(m-1,n).max(dp(m, n-1))
object Solution {
    def longestCommonSubsequence(text1: String, text2: String): Int = {
        var dp0 = new Array[Int](text2.length+1)
        var dp1 = new Array[Int](text2.length+1)
        for (i<-1 to text1.length) {
            for (j<-1 to text2.length) {
                dp1(j) = if (text1(i-1)==text2(j-1)) dp0(j-1) + 1
                    else dp0(j).max(dp1(j-1))
            }
            val t = dp0; dp0 = dp1; dp1 = t
        }
        dp0(text2.length)
    }
}