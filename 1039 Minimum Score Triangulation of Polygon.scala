object Solution {
    def minScoreTriangulation(A: Array[Int]): Int = {
        if (A.length < 3) return 0
        val r = new Array[Array[Int]](A.length + 1)
        r(2) = Array.fill(A.length -1)(0)
        for (L <- 3 to A.length) {
            val maxIndex = A.length - L
            r(L) = new Array[Int](maxIndex + 1)
            for (i <- 0 to maxIndex) {
                val t = A(i) * A(i + L - 1)
                r(L)(i) = (i + 1 until i + L - 1)
                    .map{ k=>
                        t * A(k) + r(k - i + 1)(i) + r(i + L- k)(k)
                    }.min
            }
        }
        r(A.length)(0)
    }
}