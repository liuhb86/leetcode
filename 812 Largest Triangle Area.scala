import scala.math.abs
object Solution {
    def largestTriangleArea(points: Array[Array[Int]]): Double = {
        var r = 0.0
        for (i<-points.indices) {
            val Array(x0,y0) = points(i)
            for (j<- i+1 until points.length) {
                val Array(x1,y1) = points(j)
                for (k <- j+1 until points.length) {
                    val Array(x2,y2) = points(k)
                    r = r.max(abs(x0*(y1-y2)+x1*(y2-y0)+x2*(y0-y1))/2.0)
                }
            }
        }
        r
    }
}