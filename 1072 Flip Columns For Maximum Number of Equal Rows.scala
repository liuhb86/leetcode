import scala.collection.mutable.ArrayBuffer
object Solution {
  def maxEqualRowsAfterFlips(matrix: Array[Array[Int]]): Int = {
    val d = ArrayBuffer[Array[Int]]()
    val c = ArrayBuffer[Int]()
    for (r <- matrix) {
      val i = d.indexWhere(isSame(_, r))
      if (i >= 0) {
          c(i) += 1
      } else {
          d += r
          c += 1
      }
    }
    c.max
  }

  def isSame(a: Array[Int], b: Array[Int]) : Boolean = {
    val s = a(0) == b(0)
    for (i<- 1 until a.length) {
      if ((a(i) == b(i)) != s) return false
    }
    true
  }
}