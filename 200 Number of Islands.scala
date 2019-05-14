object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        var count = 0
        for (i<-0 until grid.length) {
            for (j<-0 until grid(i).length) {
                if (grid(i)(j) == '1') {
                    count += 1
                    flood(grid, i, j)
                }
            }
        }
        count
    }
    
    def flood(grid: Array[Array[Char]], i: Int, j: Int) : Unit = {
        if (i< 0 || i >= grid.length) return
        if (j < 0 || j >= grid(i).length) return
        if (grid(i)(j) == '0') return
        grid(i)(j) = '0'
        flood(grid, i-1, j)
        flood(grid, i+1,j)
        flood(grid, i, j-1)
        flood(grid, i, j+1)
    }
}