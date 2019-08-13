import scala.collection.mutable.Queue
object Solution {
    def subarraysWithKDistinct(A: Array[Int], K: Int): Int = {
        val map = scala.collection.mutable.Map[Int, Queue[Int]]()
        var i = 0
        var j = 0
        var p = 0
        var r = 0
        for (i<-A.indices) {
            if (i > 0) {
                val v = A(i-1)
                if (map(v).size==1) map -= v
                else {
                    map(v).dequeue
                    p = p.max(map(v).head)
                }
            }
            while (j<A.length && (map.size < K || map.contains(A(j)))) {
                val v = A(j)
                val q = map.getOrElseUpdate(v, Queue[Int]())
                if (q.isEmpty) p = j
                q += j
                j += 1
            }
            if (map.size < K) return r
            r += j - p
            //println(r)
        }
        r
    }
}