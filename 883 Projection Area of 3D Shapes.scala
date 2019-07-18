object Solution {
    def projectionArea(grid: Array[Array[Int]]): Int = {
        val xy = grid.map(_.count(_ > 0)).sum
        val yz = grid.map(_.max).sum
        val zx = grid.indices.map(c => grid.map(_(c)).max).sum
        xy+yz+zx
    }
}