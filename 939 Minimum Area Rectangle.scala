import scala.math.abs
object Solution {
    def minAreaRect(points: Array[Array[Int]]): Int = {
        val p = points.map(a=> (a(0).toLong, a(1).toLong))
        val ps = p.toSet
        var r = Long.MaxValue
        for (i<-p.indices) {
            val p1 = p(i)
            for (j<-i+1 until p.length) {
                val p2 = p(j)
                if (p1._1 != p2._1 && p1._2 != p2._2) {
                    if (ps((p1._1, p2._2)) && ps((p2._1, p1._2))) {
                        r = r.min(abs(p1._1-p2._1)*abs(p1._2-p2._2))
                    }
                }
            }
        }
        if (r == Long.MaxValue) 0 else r.toInt
    }
}