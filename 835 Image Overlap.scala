import scala.math.abs
object Solution {
    def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
        val N = A.length
        val a2 = A.map(x => toInt(x))
        val b2 = B.map(x => toInt(x))
        var r = 0
        for (dx0 <- -(N-1) to N-1) {
            val (a,b) = if (dx0 < 0) (b2,a2) else (a2,b2)
            val dx = abs(dx0)
            val at = a.map(_ >> dx)
            val mask = (1 << (N - dx)) - 1
            val bt = b.map(_ & mask)
            for (dy0 <- -(N-1) to N-1) {
                val (ay, by) = if (dy0 < 0) (bt, at) else (at, bt)
                val dy = abs(dy0)
                var s = 0
                for (i<- 0 until N-dy) {
                    s += Integer.bitCount(ay(i) & by(i+dy))
                }
                r = r.max(s)
            }
        }
        r
    }
    
    def toInt(a: Array[Int]) : Int = {
        var r = 0
        for (x<- a) r = (r << 1) | x
        r
    }
}