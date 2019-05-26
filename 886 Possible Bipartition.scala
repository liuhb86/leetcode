object Solution {
  def possibleBipartition(N: Int, dislikes: Array[Array[Int]]): Boolean = {
    val group = Array.fill(N+1)(-1)
    val g = (dislikes ++ dislikes.map(x => Array(x(1),x(0)))).groupBy(_(0)).mapValues(_.map(_(1)))
    for (i<-1 to N) {
      if (group(i) < 0) {
        if (!assign(g, i, group, 0)) return false
      }
    }
    true
  }

  def assign(g: Map[Int, Array[Int]], i: Int, group: Array[Int], j: Int) : Boolean = {
    if (group(i) == 1-j) return false
    if (group(i) == j) return true
    group(i) = j
    for (d <- g.getOrElse(i, Array())) {
      if (!assign(g, d, group, 1-j)) return false
    }
    true
  }
}