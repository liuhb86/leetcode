object Solution {
    def bagOfTokensScore(tokens: Array[Int], P: Int): Int = {
        val t = tokens.sorted
        var i = 0
        var j = t.length - 1
        var p = P
        var s = 0
        while (i<=j) {
            while (i<=j && p >= t(i)) {
                p -= t(i)
                s += 1
                i += 1
            }
            if (i<j && s>0) {
                p += t(j)
                s -= 1
                j -= 1
            } else {
                i = j+1
            }
        }
        s
    }
}