object Solution {
    def maxKilledEnemies(grid: Array[Array[Char]]): Int = {
        if (grid.isEmpty) return 0
        val M = grid.length
        val N = grid.head.length
        val s = Array.ofDim[Int](M,N)
        
        for(i<-0 until M) {
            var p = 0
            var q = 0 
            var e = 0
            while (q<=N) {
                if (q==N || grid(i)(q)=='W') {
                    for (k<-p until q) s(i)(k) = e
                    p = q + 1
                    e = 0
                } else if (grid(i)(q) == 'E') {
                    e += 1
                }
                q += 1
            }
        }
        //println(s.map(_.mkString(" ")).mkString("\n"))
        
        var r = 0
        for (j<-0 until N) {
            var p = 0
            var q = 0
            var e = 0
            while (q<=M) {
                if (q==M || grid(q)(j) == 'W') {
                    for (k<-p until q if grid(k)(j) == '0') {
                       r = r.max(e + s(k)(j))
                    }
                    p = q + 1
                    e = 0
                } else if (grid(q)(j) == 'E') {
                    e += 1
                }
                q += 1
            }
        }
        
        r
    }
}