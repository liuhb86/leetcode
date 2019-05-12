import scala.math.{max, min}
object Solution {
    def maxSumAfterPartitioning(A: Array[Int], K: Int): Int = {
        val T = new Array[Int](A.length)
        for (i <- 0 until A.length) {
            var m = A(i)
            var mm = A(i)
            for (j <- i - 1 to max(-1 , i- K) by -1) {
                if (j == -1) {
                    val t = (i -j) * mm
                    if (t>m) m = t
                } else {
                    val t = T(j) + (i-j) * mm
                    if (t > m) m = t
                    if (A(j) > mm) mm = A(j)
                }
            }
            T(i) = m
        }
        T.foreach(x => print(s"$x,"))
        T(A.length -1)
    }
}