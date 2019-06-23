object Solution {
    def longestPalindrome(s: String): Int = {
        val d = s.groupBy(identity)
        var hasOdd = false
        var r = 0
        for ((_, x) <-d) {
            val k = x.length
            if (k % 2 == 0) r += k
            else {r += k-1; hasOdd = true}
        }
        if (hasOdd) r +1 else r
    }
}