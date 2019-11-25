import scala.collection.mutable.Map
object Solution {
    def oddCells(n: Int, m: Int, indices: Array[Array[Int]]): Int = {
        var rows = 0L
        var cols = 0L
        for (Array(r,c)<-indices) {
            rows = rows ^ (1L<<r)
            cols = cols ^ (1L<<c)
        }
        val nr = java.lang.Long.bitCount(rows)
        val nc = java.lang.Long.bitCount(cols)
        //println(nr, nc)
        nr * m + nc* n - 2* nr * nc
    }
}