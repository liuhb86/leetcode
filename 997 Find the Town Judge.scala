object Solution {
    def findJudge(N: Int, trust: Array[Array[Int]]): Int = {
        val c = new Array[Int](N)
        for (Array(a,b) <- trust) {
            c(b-1) += 1
        }
        if (c.count(_ == N-1) != 1) return -1
        val t = c.indexOf(N-1) + 1
        if (trust.exists(_(0)==t)) return -1 else t
    }
}