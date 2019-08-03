import scala.collection.mutable.Set
object Solution {
    def eventualSafeNodes(graph: Array[Array[Int]]): List[Int] = {
        var r : List[Int] = Nil
        val to = graph.map(x=> Set(x:_*))
        val from = Array.fill[List[Int]](graph.length)(Nil)
        var list : List[Int] = Nil
        for (i<-graph.indices) {
            val x = graph(i)
            if (x.isEmpty) list = i :: list
            for (j<-x) from(j) = i :: from(j)
        }
        while(list.nonEmpty) {
            var next : List[Int] = Nil
            for (j<-list) {
                r = j :: r
                for (i<-from(j)) {
                    val s = to(i)
                    s -= j
                    if (s.isEmpty) next = i :: next
                }
            }
            list = next
        }
        r.sorted
    }
}