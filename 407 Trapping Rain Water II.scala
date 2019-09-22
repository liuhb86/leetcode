// peek
import scala.collection.mutable.PriorityQueue
object Solution {
    def trapRainWater(heightMap: Array[Array[Int]]): Int = {
        if (heightMap.length < 3 || heightMap.head.length < 3) return 0
        val pq = PriorityQueue[(Int, Int, Int)]()(Ordering.by(-_._3))
        for (i<-heightMap.indices) {
            pq += ((i, 0, heightMap(i)(0)))
            heightMap(i)(0) = -1
            val k = heightMap.head.length -1
            pq += ((i, k, heightMap(i)(k)))
            heightMap(i)(k) = -1
        }
        for (i<-1 to heightMap.head.length -2) {
            pq += ((0,i, heightMap(0)(i)))
            heightMap(0)(i) = -1
            val k = heightMap.length -1
            pq += ((k, i, heightMap(k)(i)))
            heightMap(k)(i) = -1
        }
        var r = 0
        while(pq.nonEmpty) {
            val (i, j, v) = pq.dequeue
            r += trap(i,j-1,v,heightMap, pq)
            r += trap(i,j+1,v,heightMap, pq)
            r += trap(i-1,j,v,heightMap, pq)
            r += trap(i+1,j,v,heightMap, pq)
        }
        r
    }
    
    def trap(i: Int, j: Int, v: Int,
            h: Array[Array[Int]], pq: PriorityQueue[(Int, Int, Int)]) : Int = {
        if (i<0 || i>= h.length) return 0
        if (j<0 || j>=h.head.length) return 0
        if (h(i)(j) < 0) return 0
        val x = h(i)(j)
        h(i)(j) = -1
        pq += ((i,j, x.max(v)))
        val r = v - x.min(v)
        //println(i, j, v, x, r)
        r
    }
}