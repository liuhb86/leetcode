object Solution {
    def multiply(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
        if (A.isEmpty || B.isEmpty) return Array() 
        val b = B.head.indices.map(i=> (i, B.map(_(i)).zipWithIndex.filter(_._1 != 0))).filter(_._2.nonEmpty)
        val r = Array.ofDim[Int](A.length, B.head.length)
        for (i<-A.indices) {
            val a = A(i)
            if (a.exists(_!=0)) {
                for ((j, c) <- b) {
                    var s = 0
                    for ((v, k) <-c) {
                        s += v * a(k)
                    }
                    r(i)(j) = s
                }
            }
        }
        r
    }
}