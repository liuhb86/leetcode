import scala.collection.mutable.Map
import scala.math.abs
object Solution {
    
    def assignBikes(workers: Array[Array[Int]], bikes: Array[Array[Int]]): Int = {
        val map = Map[Long, Int]()
        val d = Array.ofDim[Int](workers.length, bikes.length)
        for (i<-workers.indices; j<-bikes.indices) {
            d(i)(j) = abs(workers(i)(0)-bikes(j)(0)) + abs(workers(i)(1)-bikes(j)(1))
        }
        //println(d.map(_.mkString(" ")).mkString("\n"))
        search(0, d, map, 0)
    }
    
    def search(i: Int, d: Array[Array[Int]], map: Map[Long, Int], take: Int) : Int = {
        if (i == d.length) return 0
        val c = map.get(take)
        if (c.isDefined) return c.get
        val di = d(i)
        var r = Int.MaxValue
        for (j<-di.indices) {
            if ((take & (1 << j)) == 0) {
                r = r.min(di(j) + search(i+1, d, map, take | (1 << j)))
            }
        }
        //println(i, r)
        map(take) = r
        r
    }
}