import scala.util.control.Breaks._
object Solution {
    def shortestDistance(grid: Array[Array[Int]]): Int = {
        if (grid.isEmpty) return -1
        val M = grid.length
        val N = grid.head.length
        val r = Array.ofDim[Int](M,N)
        val c = Array.ofDim[Int](M,N)
        var buildings = 0
        for (i<- 0 until M; j <- 0 until N if grid(i)(j) != 0) {
            c(i)(j) = -1
        }
        for (i<- 0 until M; j <- 0 until N) {
            if (grid(i)(j) == 1) {
                var list = List((i,j))
                var d = 0
                while (list.nonEmpty) {
                    var next: List[(Int, Int)] = Nil
                    d += 1
                    for ((x,y) <- list) {
                        next = visit(x-1, y, d, r, c, next, buildings)
                        next = visit(x+1, y, d, r, c, next, buildings)
                        next = visit(x, y-1, d, r, c, next, buildings)
                        next = visit(x, y+1, d, r, c, next, buildings)
                    }
                    list = next
                }
                buildings += 1
            }
        }
        var res = Int.MaxValue
        for (i<- 0 until M; j <- 0 until N) {
            if (grid(i)(j) == 0 && c(i)(j)==buildings) res = res.min(r(i)(j))
        }
        if (res == Int.MaxValue) -1 else res
    }
    
    def visit(x: Int, y: Int, d: Int,
              r: Array[Array[Int]], c: Array[Array[Int]], 
              next: List[(Int, Int)], b: Int) : List[(Int, Int)] = {
        if (x<0 || x>= c.length) return next
        if (y<0 || y>= c.head.length) return next
        if (c(x)(y) != b) return next
        c(x)(y) = b + 1
        r(x)(y) += d
        (x,y) :: next
    }
}