import scala.collection.mutable.{Map, PriorityQueue, ArrayBuffer}
object Solution {
    def rearrangeBarcodes(barcodes: Array[Int]): Array[Int] = {
        val m = Map[Int, Int]()
        for (b <- barcodes) {
            m(b) = m.getOrElse(b, 0) + 1
        }
        val pq = new PriorityQueue[(Int, Int)]()
        for ((b,c) <- m) {
            pq += ((c, b))
        }
        val r = new ArrayBuffer[Int](barcodes.length)
        while (!pq.isEmpty) {
            val a = pq.dequeue
            r += a._2
            if (pq.isEmpty) return r.toArray
            val b = pq.dequeue
            r += b._2
            if (a._1 > 1) pq += ((a._1 -1 , a._2))
            if (b._1 > 1) pq += ((b._1 -1 , b._2))
        }
        r.toArray
    }
}