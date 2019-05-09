import scala.collection.mutable

object Solution {
    def isBipartite(graph: Array[Array[Int]]): Boolean = {
        val toVisit = mutable.Set((0 until graph.length) : _*)
        while(!toVisit.isEmpty) {
            if (!put(toVisit.head, graph, toVisit, Array(mutable.Set[Int](), mutable.Set[Int]()), 0))               {
                return false
            }
        }
        true
    }
    
    def put(n: Int, g: Array[Array[Int]], toVisit: mutable.Set[Int], sets : Array[mutable.Set[Int]], i : Int) : Boolean = {
        if (sets(i).contains(n)) return true
        if (sets(1-i).contains(n)) return false
        sets(i) += n
        val nodes = g(n)
        toVisit -= n
        for (n2 <- nodes) {
            if (!put(n2, g, toVisit, sets, 1 - i)) return false
        }
        true
    }
}