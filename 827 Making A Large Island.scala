import scala.collection.mutable.ArrayBuffer
object Solution {
    def largestIsland(grid: Array[Array[Int]]): Int = {
        val s = new ArrayBuffer[Int]()
        s+=0;s+=0
        var g = 1
        var m  = 0
        for (i<-grid.indices) {
            for (j<-grid(i).indices) {
                if (grid(i)(j) == 1) {
                    g+=1
                    s += flood(grid, i, j ,g)
                    m = m.max(s.last)
                }
            }
        }
        
        val b = new ArrayBuffer[Int](4)
        for (i<-grid.indices) {
            for (j<-grid(i).indices) {
                if (grid(i)(j) == 0) {
                    b.clear()
                    var t = 1
                    t += size(grid, i-1,j,s,b)
                    t += size(grid, i+1,j,s,b)
                    t += size(grid, i,j-1,s,b)
                    t += size(grid, i,j+1,s,b)
                    m = m.max(t)
                }
            }
        }
        m
    }
    
    def size(grid: Array[Array[Int]], i: Int, j: Int, s: ArrayBuffer[Int], b: ArrayBuffer[Int]) : Int = {
        if (i<0 || i>=grid.length) return 0
        if (j<0 || j>=grid(i).length) return 0
        val g = grid(i)(j)
        if (g == 0 || b.indexOf(g) >=0) return 0
        b += g
        s(g)
    }
    
    def flood(grid: Array[Array[Int]], i: Int, j: Int, g: Int) : Int = {
        if (i<0 || i>=grid.length) return 0
        if (j<0 || j>=grid(i).length) return 0
        if (grid(i)(j) != 1) return 0
        grid(i)(j) = g
        var c = 1
        c += flood(grid, i-1,j,g)
        c += flood(grid, i+1,j,g)
        c+= flood(grid, i, j-1,g)
        c+= flood(grid, i, j+1,g)
        c
    }
}