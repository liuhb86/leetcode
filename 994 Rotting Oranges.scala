object Solution {
    def orangesRotting(grid: Array[Array[Int]]): Int = {
        var rot = (for(i<-grid.indices; j<-grid(i).indices if grid(i)(j)==2) yield (i,j)).toList
        var t = 0
        while(rot.nonEmpty) {
            t += 1
            var next : List[(Int, Int)] = Nil
            for ((i,j)<-rot) {
                next = flood(grid, i-1, j, next)
                next = flood(grid, i+1, j, next)
                next = flood(grid, i, j-1, next)
                next = flood(grid, i, j+1, next)
            }
            rot = next
        }
        if (grid.exists(_.exists(_==1))) return -1
        (t - 1).max(0)
    }
    
    def flood(grid: Array[Array[Int]], i: Int, j: Int, list: List[(Int, Int)]) : List[(Int, Int)] = {
        if (i<0 || i>=grid.length) return list
        if (j<0 || j>=grid(i).length) return list
        if (grid(i)(j) != 1) return list
        grid(i)(j) = 2
        (i,j) :: list
    }
}