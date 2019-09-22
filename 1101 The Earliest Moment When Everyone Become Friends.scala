import scala.collection.mutable.PriorityQueue
object Solution {
    def earliestAcq(logs: Array[Array[Int]], N: Int): Int = {
        var g = N
        val pq = PriorityQueue(logs:_*)(Ordering.by(-_(0)))  
        val p = (0 until N).toArray
        var last= 0
        while (g > 1 && pq.nonEmpty) {
            val Array(t, a,b) = pq.dequeue
            last = t
            val ra = uf(p,a)
            val rb = uf(p,b)
            if (ra != rb) {
                p(rb) = ra
                g -= 1
            }
        }
        if (g == 1) last else -1
    }
    def uf(p: Array[Int], i: Int) : Int = {
        if (p(i) == i) return i
        p(i) = uf(p, p(i))
        p(i)
    }
}