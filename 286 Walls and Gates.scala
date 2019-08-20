object Solution {
    val INF = 2147483647
    def wallsAndGates(rooms: Array[Array[Int]]): Unit = {
        var cur = (for (i<-rooms.indices; j<-rooms(i).indices if rooms(i)(j)==0) yield(i,j) ).toList
        var d = 0
        while (cur.nonEmpty) {
            d += 1
            var next: List[(Int, Int)] = Nil
            for ((i,j) <- cur) {
                next = visit(rooms, i-1, j, d, next)
                next = visit(rooms, i+1, j, d, next)
                next = visit(rooms, i, j-1, d, next)
                next = visit(rooms, i, j+1, d, next)
            }
            cur = next
        }
    }
    
    def visit(rooms: Array[Array[Int]], i: Int, j:Int, d: Int, list: List[(Int, Int)]) : List[(Int, Int)] = {
        if (i < 0 || i >= rooms.length ) return list
        if (j < 0 || j >= rooms(i).length) return list
        if (rooms(i)(j) != INF) return list
        rooms(i)(j) = d
        (i, j) :: list
    }
}