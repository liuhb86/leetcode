object Solution {
    def maxDistance(grid: Array[Array[Int]]): Int = {
        var list = (for (i<-grid.indices; j<-grid(i).indices if grid(i)(j) == 1) yield (i,j)).toList
        var r = -1
        while(list.nonEmpty) {
            r+=1
            var next: List[(Int, Int)] = Nil
            for ((i,j)<-list) {
                next = visit(grid, i-1, j, next)
                next = visit(grid, i+1,j,next)
                next = visit(grid, i,j-1, next)
                next = visit(grid, i, j+1, next)
            }
            list = next
        }
        if (r<=0) -1 else r
    }
    def visit(grid: Array[Array[Int]], i: Int, j: Int, list: List[(Int, Int)]) : List[(Int, Int)] = {
        if (i<0 || i>=grid.length) return list
        if (j<0 || j>=grid(i).length) return list
        if (grid(i)(j) != 0) return list
        grid(i)(j) = 1
        (i,j) :: list
    }
}