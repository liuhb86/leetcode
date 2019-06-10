object Solution {
    def pacificAtlantic(matrix: Array[Array[Int]]): List[Array[Int]] = {
        if (matrix.length == 0 || matrix.head.length == 0) return Nil
        val m = matrix.length
        val n = matrix.head.length
        val r = Array.ofDim[Int](m,n)
        for (i<-0 until m) flood(matrix, r, i, 0, 1, 0)
        for (i<-0 until n) flood(matrix, r, 0, i, 1, 0)
        for (i<-0 until m) flood(matrix, r, i, n -1, 2, 0)
        for (i<-0 until n) flood(matrix, r, m-1,i, 2, 0)
        println(r.map(_.mkString(",")).mkString("\n"))
        (for (i<-0 until m; j<-0 until n if r(i)(j)==3) 
            yield Array(i,j)).toList
    }
    
    def flood(matrix: Array[Array[Int]], result: Array[Array[Int]],
             x: Int, y: Int, v : Int, p : Int) {
        if (x< 0 || x>= matrix.length) return
        if (y<0 || y>=matrix(x).length) return
        if ((result(x)(y) & v) >0) return
        val h = matrix(x)(y)
        if (h<p) return
        result(x)(y) += v
        flood(matrix, result, x-1, y, v, h)
        flood(matrix, result, x+1, y, v, h)
        flood(matrix, result, x, y-1, v, h)
        flood(matrix, result, x, y+1, v, h)
    }
}