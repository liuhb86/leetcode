import scala.util.control.Breaks._
object Solution {
    def updateMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
        val r = Array.fill(matrix.length)(Array.fill(matrix.head.length)(-1))
        var q: List[(Int,Int)] = Nil
        for (i<-matrix.indices; j<-matrix.head.indices) {
            if (matrix(i)(j) == 0) {
                r(i)(j) = 0
                q = add(r, i, j, 1, q)
            }
        }
        
        var d = 2
        while (q != Nil) {
            var next : List[(Int,Int)] = Nil 
            for ((i,j) <- q) next = add(r, i, j, d, next)
            q = next
            d += 1
        }
        r
    }
    
     def add(r: Array[Array[Int]], i: Int, j: Int, d: Int, _q: List[(Int,Int)]) : List[(Int,Int)] = {
        var q = _q
        q = add1(r, i-1, j, d,q)
        q = add1(r, i+1, j, d,q)
        q = add1(r, i, j-1, d, q)
        q = add1(r, i, j+1, d, q)
        q
     }
    
    def add1(r: Array[Array[Int]], i: Int, j: Int, d: Int, q: List[(Int,Int)]) : List[(Int,Int)] = {
        if (i<0 || i>=r.length) return q
        if (j<0 || j>=r.head.length) return q
        if (r(i)(j) >= 0) return q
        r(i)(j) = d
        (i,j) :: q
    }
}