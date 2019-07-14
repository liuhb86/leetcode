object Solution {
    def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = {
        var r = 0
        val s = scala.collection.mutable.ArrayBuffer[Int]()
        for (i<-0 to A.length) {
            while(s.nonEmpty && (i == A.length || A(s.last) <= A(i))) {
                val j = s.last
                s.trimEnd(1)
                if (A(j)>= L && A(j) <= R) {
                    val k = if (s.isEmpty) -1 else s.last
                    r += (j-k) * (i-j)
                }
            }
            s += i
        }
        r
    }
}