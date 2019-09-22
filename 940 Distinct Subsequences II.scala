object Solution {
    val M = 1000000007
    def distinctSubseqII(S: String): Int = {
        val endWith = new Array[Long](26)
        var r = 0L
        for (c<-S) {
            val x = c-'a'
            val ex = (r + 1) % M
            r = (r + ex - endWith(x) + M) % M
            endWith(x) = ex
        }
        r.toInt
    }
}