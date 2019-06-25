object Solution {
    val M = 1000000007
    val hop=Array(
        Array(4,6),
        Array(6,8),
        Array(7,9),
        Array(4,8),
        Array(3,9,0),
        Array(),
        Array(1,7,0),
        Array(2,6),
        Array(1,3),
        Array(2,4)
    )
    def knightDialer(N: Int): Int = {
        var current = Array.fill(10)(1L)
        var next = new Array[Long](10)
        for (i<-1 until N) {
            for (j<-0 to 9) {
                var s = 0L
                for (d<-hop(j)) s = (s + current(d)) % M
                next(j) = s
            }
            val t = current; current = next; next = t
        }
        (current.sum % M).toInt
    }
}