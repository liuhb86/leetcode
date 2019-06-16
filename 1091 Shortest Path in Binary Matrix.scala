import scala.util.control.Breaks._
object Solution {
    def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
        if (grid(0)(0) != 0) return -1
        val n = grid.length
        val n1 = n-1
        if (grid.length == 1) return 1
        val visited = Array.fill(grid.length)(Array.fill(grid.length)(false))
        var length = 1
        var current = List((0,0))
        while (current != Nil) {
            length += 1
            var next: List[(Int, Int)] = Nil
            for ((x,y)<-current) {
                for (i<- -1 to 1; j<- -1 to 1) { breakable {
                    if (i ==0 && j==0) break
                    val x1 = x+i; val y1 = y+j;
                    if (x1<0 || x1>=n) break
                    if (y1<0 || y1>=n) break
                    if (grid(x1)(y1) != 0) break
                    if (visited(x1)(y1)) break
                    if (x1 == n1 && y1==n1) return length
                    visited(x1)(y1) = true
                    next = (x1, y1) :: next
                }}
            }
            current = next
        }
        -1
    }
}