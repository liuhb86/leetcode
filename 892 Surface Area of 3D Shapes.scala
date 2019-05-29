import scala.math.min
object Solution {
    def surfaceArea(grid: Array[Array[Int]]): Int = {
        var area = 0
        for (i<- 0 until grid.length) {
            for (j <-0 until grid(i).length) {
                val h = grid(i)(j)
                area += h *4
                if (h >0) area += 2
                if (i >0) area -= min(h, grid(i-1)(j)) * 2
                if (j >0) area -= min(h, grid(i)(j-1)) * 2
            }
        }
        area
    }
}