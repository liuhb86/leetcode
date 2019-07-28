import scala.util.control.Breaks._
object Solution {
    def largest1BorderedSquare(grid: Array[Array[Int]]): Int = {
        var r = 0
        val s1 = Array.ofDim[Int](grid.length, grid.head.length+1)
        val s2 = Array.ofDim[Int](grid.length+1, grid.head.length)
        for (i<- grid.indices) {
            for (j<- grid(i).indices) {
                s1(i)(j+1) = s1(i)(j) + grid(i)(j)
                s2(i+1)(j) = s2(i)(j) + grid(i)(j)
            }
        }
        breakable { for (i<-grid.indices) {
            if (grid.length - i < r || grid(i).length < r) break
            breakable { for (j<-grid(i).indices if grid(i)(j) == 1) {
                val ml = (grid(i).length - j).min(grid.length - i)
                if (ml < r) break
                for (L <- ml to r + 1 by -1) {
                    val k = j + L
                    if (s1(i)(k)-s1(i)(j) == L && s2(i+L)(j) - s2(i)(j)==L && 
                        s2(i+L)(k-1)-s2(i)(k-1) == L && s1(i+L-1)(k) - s1(i+L-1)(j) == L) {
                        r = r.max(L)
                    }
                }
            }}
        }}
        r * r
    }
}