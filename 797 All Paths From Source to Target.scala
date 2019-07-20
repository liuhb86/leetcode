object Solution {
    def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
        val N= graph.length
        val reverse = Array.fill[List[Int]](graph.length)(Nil)
        for (i<-graph.indices; j<- graph(i)) {
            reverse(j) = i :: reverse(j)
        }
        val reachable = new Array[Boolean](graph.length)
        reachable(0) = true
        for (i<-0 to N-1) {
           for (j<- graph.indices) {
               if (reachable(j)) {
                   for (k<-graph(j)) reachable(k) = true
               }
           }     
        }
        //println(reachable.mkString(" "))
        var r : List[List[Int]] = Nil
        var p = List(List(N-1))
        while (p!= Nil) {
            var pn : List[List[Int]] = Nil
            for (x<-p) {
                if (x.head == 0) {
                    r = x::r
                } else {
                    for (prev <- reverse(x.head) if reachable(prev)) {
                        pn = (prev::x) :: pn
                    }
                }
            }
            p = pn
        }
        r
    }
}