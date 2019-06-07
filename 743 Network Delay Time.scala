import scala.collection.mutable.Set
object Solution {
    def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {
        val d = Array.fill[Option[Int]](N+1)(None)
        val g = times.groupBy(_(0))
        d(K) = Some(0)
        var current = Set[Int](K)
        while (current.nonEmpty) {
            var next = Set[Int]()
            for (c <- current) {
                val dc = d(c).get
                if (g.contains(c)) {
                    for (Array(_,n, v)<-g(c)) {
                        if (d(n).isEmpty || dc + v < d(n).get) {
                            d(n) = Some(dc+v)
                            next += n
                        }
                    }
                }
            }
            current = next
        }
        val r = d.tail
        if (r.exists(_.isEmpty)) -1
        else r.map(_.get).max
    }
}