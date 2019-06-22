object Solution {
    def prefixesDivBy5(A: Array[Int]): Array[Boolean] = {
        val r = new Array[Boolean](A.length)
        var v = 0
        for (i<-A.indices) {
            v = ((v << 1) + A(i)) % 5
            r(i) = (v == 0)
        }
        r
    }
}