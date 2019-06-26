object Solution {
    def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
        var a = 0
        for (i<-grid.indices; j<-grid(i).indices) {
            if (grid(i)(j)==1) a = a.max(flood(grid,i,j))
        }
        a
    }
    
    def flood(grid: Array[Array[Int]], i: Int, j:Int) : Int = {
        if (i<0 || i>=grid.length) return 0
        if (j<0|| j>=grid.head.length) return 0
        if (grid(i)(j) != 1) return 0
        grid(i)(j) = 2
        var a = 1
        a += flood(grid, i-1,j)
        a += flood(grid, i+1,j)
        a += flood(grid, i, j-1)
        a += flood(grid, i, j+1)
        a
    }
}