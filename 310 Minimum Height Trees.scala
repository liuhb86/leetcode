// peel onion
import scala.collection.mutable.{Set, Map}
object Solution {
    def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
        if (n == 1) return List(0)
        if (n==2) return edges.head.toList
        val g  = Map[Int,Set[Int]]()
        for (i<-0 to n-1) g(i) = Set[Int]()
        for (Array(a,b)<-edges) {
            g(a) += b
            g(b) +=a
        }
        var leaf = g.filter(_._2.size == 1).keySet.toList
        val r = Set((0 to n-1):_*)
        r --= leaf
        while (r.size > 2) {
            var next : List[Int] = Nil
            for (n<- leaf) {
                for (x <- g(n)) {
                    val s = g(x)
                    s-=n
                    g(x) -= n
                    //println(s"$x - $n = ${s.mkString}")
                    //println(g(x).mkString)
                    if (s.size == 1) next = x :: next
                }
            }
            leaf = next
            //println(leaf.mkString(","))
            r--= leaf
        }
        r.toList
    }
}