object Solution {
  def canReorderDoubled(A: Array[Int]): Boolean = {
    val s = scala.collection.mutable.Map(A.groupBy(identity).mapValues(_.length).toSeq: _*)
    val n = s.keySet.toArray.sorted
    for (x<-n) {
      while(s(x) > 0) {
        s(x) -= 1
        if (x < 0 && x % 2 == 1) return false
        val d = if (x >= 0) x*2 else x / 2
        if (s.contains(d) && s(d) > 0) {
          s(d) -= 1
        } else {
          return false
        }
      }
    }
    true
  }
}