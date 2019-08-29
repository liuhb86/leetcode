import scala.collection.mutable.Map
object Solution {
    def longestArithSeqLength(A: Array[Int]): Int = {
        if (A.isEmpty) return 0
        val dp = Array.fill(A.length)(Map[Int, Int]())
        var r = 1
        for (i<-A.indices) {
            for (j<-0 until i) {
                val d = A(i) - A(j)
                val v = dp(j).getOrElse(d, 1) + 1
                dp(i)(d) = v
                r = r.max(v)
            }
        }
        r
    }
}