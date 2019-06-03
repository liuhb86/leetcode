import scala.math.sqrt
object Solution {
  val M = 1000000007
  def numFactoredBinaryTrees(A: Array[Int]): Int = {
    val sorted = A.sorted
    val s=sorted.zipWithIndex.toMap
    var sum = 0L
    val c = Array.fill(sorted.length)(1L)
    for (i<- 0 until sorted.length) {
      val r = sorted(i)
      val u = sqrt(r).toInt
      var j = 0
      while (j<i && sorted(j) <= u) {
        val a = sorted(j)
        if (r % a == 0 && s.contains(r/a)) {
          val k = s(r/a)
          val t = if (j==k) c(j)*c(k) else c(j)*c(k)*2
          c(i) = (c(i) + t)% M
        }
        j += 1
      }
      sum = (sum + c(i)) % M
    }
    sum.toInt
  }
}