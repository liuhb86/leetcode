object Solution {
    def minDominoRotations(A: Array[Int], B: Array[Int]): Int = {
        var r = A.length
        for (t <- Seq(A.head, B.head)) {
            if (A.indices.forall(i=> A(i)==t || B(i)==t)) {
                var a = A.count(_ != t)
                var b = B.count(_ != t)
                r = r.min(a).min(b)
            }
        }
        if (r == A.length) -1 else r
    }
}