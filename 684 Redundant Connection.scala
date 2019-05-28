import scala.collection.mutable.{Set, Map}
object Solution {
  def findRedundantConnection(edges: Array[Array[Int]]): Array[Int] = {
    val g = Map[Int, Set[Int]]()
    for (e <- edges) {
      val s = g.getOrElseUpdate(e(0), Set[Int]())
      s += e(1)
      val s1 = g.getOrElseUpdate(e(1), Set[Int]())
      s1 += e(0)
    }
    val leafSet = Set[Int]()
    for ((n,s) <- g) {
      if (s.size == 1) leafSet += n
    }
    while (leafSet.nonEmpty) {
      val n = leafSet.head
      for (m <- g(n)) {
        val s = g(m)
        s -= n
        if (s.size == 1) {
          leafSet += m
        } else if (s.isEmpty) {
          leafSet -= m
          g -= m
        }
      }
      leafSet -= n
      g -=n
    }
    for (i <- edges.length -1 to 0 by -1) {
      val Array(m,n) = edges(i)
      if (g.contains(m) && g.contains(n)) return Array(m,n)
    }
    null
  }
}