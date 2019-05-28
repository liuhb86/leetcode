object Solution {
  def minIncrementForUnique(A: Array[Int]): Int = {
    if (A.length == 0) return 0
    val sorted = A.sorted
    var u = sorted(0)
    var m = 0
    for (i <- 1 until sorted.length) {
      val n = scala.math.max(u + 1, sorted(i))
      m += (n - sorted(i))
      u = n
    }
    m
  }
}