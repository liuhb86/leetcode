object Solution {
    def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
        val rm = grid.map(_.max)
        val cm = (0 until grid.head.length).map(c => grid.map(_(c)).max)
        var increase = 0
        for (i <- 0 until grid.length) {
            for (j <- 0 until grid(i).length) {
                increase += scala.math.min(rm(i), cm(j)) - grid(i)(j)
            }
        }
        increase
    }
}