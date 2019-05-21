object Solution {
    
    val visited = 2000
    
    def colorBorder(grid: Array[Array[Int]], r0: Int, c0: Int, color: Int): Array[Array[Int]] = {
        val origColor = grid(r0)(c0)
        mark(grid, r0, c0, origColor, color)
        clean(grid, r0, c0)
        grid
    }
    
    def mark(grid: Array[Array[Int]], x: Int, y: Int, origColor : Int, color: Int) : Boolean = {
        if (x < 0 || x >= grid.length) return false
        if (y < 0 || y >= grid(x).length) return false
        if (grid(x)(y) >= visited) return true
        if (grid(x)(y) != origColor) return false
        grid(x)(y) += visited
        val isInner = 
            mark(grid, x -1, y, origColor, color) &
            mark(grid, x +1, y, origColor, color) &
            mark(grid, x , y -1, origColor, color) &
            mark(grid, x, y + 1, origColor, color) 
        if (!isInner) grid(x)(y) = visited + color
        true
    }
    
     def clean(grid: Array[Array[Int]], x: Int, y: Int) : Unit = {
         if (x < 0 || x >= grid.length) return 
         if (y < 0 || y >= grid(x).length) return
         if (grid(x)(y) < visited) return
         grid(x)(y) -= visited
         clean(grid, x-1, y)
         clean(grid, x+1, y)
         clean(grid, x, y-1)
         clean(grid, x, y+1)
     }
}