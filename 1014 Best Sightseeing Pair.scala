object Solution {
    def maxScoreSightseeingPair(A: Array[Int]): Int = {
        var v = A.head
        var m = A(1) + A(0) - 1
        for (i<-1 until A.length) {
            v -= 1
            val c = A(i)
            m = m.max(c+v)
            v = c.max(v)
        }
        m
    }
}