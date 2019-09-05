object Solution {
    def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
        if (matrix.isEmpty || matrix.head.isEmpty) return 0
        val lip = Array.ofDim[Int](matrix.length, matrix.head.length)
        var m = 0
        for (i<-matrix.indices; j<- matrix.head.indices) {
            m = m.max(solve(i, j, lip, matrix, None))
        }
        m
    }
    
    def solve(i: Int, j: Int, lip: Array[Array[Int]], matrix: Array[Array[Int]], limit: Option[Int]) : Int = {
        if (i<0 || i>= matrix.length) return 0
        if (j<0 || j>= matrix(i).length) return 0
        if (limit.isDefined && matrix(i)(j) <= limit.get) return 0
        if (lip(i)(j) > 0) return lip(i)(j)
        val l = Some(matrix(i)(j))
        var r = solve(i-1, j, lip, matrix, l)
        r = r.max(solve(i+1, j, lip, matrix,l))
        r = r.max(solve(i, j-1, lip, matrix,l))
        r = r.max(solve(i, j+1, lip, matrix,l))
        lip(i)(j) = r + 1
        r + 1
    }
}