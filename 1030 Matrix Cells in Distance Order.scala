import scala.math.{min,max, abs}
import scala.collection.mutable.ArrayBuffer
object Solution {
    def allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
        val result = new ArrayBuffer[Array[Int]](R*C)
        val maxDist = Seq(dist(r0, c0, 0,0), dist(r0,c0, 0, C-1),
                          dist(r0,c0,R-1, 0), dist(r0,c0, R-1, C-1)).max
        for (d <- 0 to maxDist) {
            for (r <- max(r0-d,0) to min(r0+d, R-1)) {
                val d1 = d - abs(r0-r)
                val c1 = c0 - d1
                if (c1 >=0) result += Array(r, c1)
                if (d1 > 0) {
                    val c2 = c0 + d1
                    if (c2 < C) result += Array(r, c2)
                }
            }
        }
        result.toArray
    }
    
    def dist(r1: Int, c1: Int, r2: Int, c2: Int ) = {
        abs(r1-r2) + abs(c1-c2)
    }
}