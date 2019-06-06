object Solution {
    def islandPerimeter(grid: Array[Array[Int]]): Int = {
        for (i<-grid.indices) {
            for (j<-grid(i).indices) {
                if (grid(i)(j) ==1) return flood(i,j, grid)
            }
        }
        0
    }
    
    def flood(i:Int, j: Int, g: Array[Array[Int]]) : Int = {
        if (i<0 || i>= g.length) return 1
        if (j<0 || j>=g(i).length) return 1
        if (g(i)(j) == 0) return 1
        if (g(i)(j) == 2) return 0 
        g(i)(j) = 2
        flood(i-1,j,g) + flood(i+1,j,g) + flood(i,j-1,g) + flood(i, j+1,g)
    }
}