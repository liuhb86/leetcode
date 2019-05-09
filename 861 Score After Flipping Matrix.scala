import scala.math.max
object Solution {
    def matrixScore(A: Array[Array[Int]]): Int = {
        val c1 = A.map(r => if (r(0) == 1) r else r.map(1-_))
        val c2 = c1.map(_.map(1-_))
        max(score(c1), score(c2))
    }
    
    def score(A: Array[Array[Int]]) : Int = {
        var score = 0
        val nCol = A(0).length
        val nRow = A.length
        for (i <- 0 until nCol) {
            val iCol = nCol -i - 1
            val count = A.map(_(iCol)).sum
            val v = max(count, nRow-count)
            score += (v << i)
        }
        score
    }
}