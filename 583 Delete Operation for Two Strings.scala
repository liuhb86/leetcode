object Solution {
    def minDistance(word1: String, word2: String): Int = {
        var dp = new Array[Int](word2.length+1)
        var dp2 = new Array[Int](word2.length+1)
        for (i<-0 to word2.length) dp(i) = i
        for (i<- 1 to word1.length) {
            dp2(0) = i
            for(j<- 1 to word2.length) {
                dp2(j) =
                    if (word1(i-1)==word2(j-1)) dp(j-1)
                    else dp(j).min(dp2(j-1)) + 1
            }
            val t = dp; dp = dp2; dp2=t
        }
        dp(word2.length)
    }
}