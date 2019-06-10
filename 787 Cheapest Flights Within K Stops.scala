object Solution {
    def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, K: Int): Int = {
        var p = Array.fill(n)(-1)
        var q = Array.fill(n)(-1)
        val g = flights.groupBy(_(0))
        p(dst) = 0
        for (i<- 0 to K) {
            for((s, t) <- g) {
                q(s) = p(s)
                for (Array(_, to, price) <- t) {
                    if (p(to) >=0) {
                        val np = price + p(to)
                        if (q(s)< 0 || np < q(s)) q(s) = np 
                    }
                }
            }
            val z = p; p = q; q = z;
        }
        p(src)
    }
}