import scala.collection.mutable.Set
object Solution {
    def shortestAlternatingPaths(n: Int, red_edges: Array[Array[Int]], blue_edges: Array[Array[Int]]): Array[Int] = {
        val n2 = n* 2
        val g0 = Array.fill[Set[Int]](n2)(Set())
        for (e<- red_edges) {
            val s = e(0); val t = e(1) + n
            val gs = g0(s)
            gs += t
        }
        for (e<-blue_edges) {
            val s = e(0) + n; val t = e(1)
            val gs = g0(s)
            gs += t
        }
        val g = g0.map(_.toArray)
        val d = Array.fill(n2)(1000)
        d(0) = 0; d(n) = 0;
        for (i<-1 to n2) {
            for (s<-g.indices) {
                for (t<-g(s)) {
                    d(t) = d(t).min(d(s) + 1)
                }
            }
            //println(d.mkString(" "))
        }
        val r = new Array[Int](n)
        for (i<-r.indices) {
            val v = d(i).min(d(i+n))
            r(i) = if (v == 1000) -1 else v
        }
        r
    }
}