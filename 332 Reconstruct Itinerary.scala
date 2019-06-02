import scala.collection.mutable.{Map, Set, ListBuffer}
object Solution {
  def findItinerary(tickets: List[List[String]]): List[String] = {
    val g1 = Map[String, Map[String, Int]]()
    val g2 = Map[String, Map[String, Int]]()
    for (List(src,dest) <- tickets) {
      val d = g1.getOrElseUpdate(src, Map[String, Int]())
      d(dest) = d.getOrElse(dest, 0) + 1
      val s = g2.getOrElseUpdate(dest, Map[String,Int]())
      s(src) = s.getOrElse(src, 0) + 1
    }
    var src = "JFK"
    var result = ListBuffer[String]()
    result += src
    while(g1.nonEmpty) {
      val dest = findNext(g1, g2, src)
      result += dest
      remove(g1, src, dest)
      remove(g2, dest, src)
      src = dest
    }
    result.toList
  }

  def findNext(g1: Map[String, Map[String, Int]], g2: Map[String, Map[String, Int]], src: String) : String = {
    val d = g1(src)
    if (d.size == 1) return d.head._1
    val r = Set[String]()
    reachable(src, g2, r)
    d.keySet.intersect(r).toArray.min
  }

  def reachable(d: String, g2: Map[String, Map[String, Int]], r: Set[String]) {
    if (r.contains(d)) return
    r += d
    if (!g2.contains(d)) return
    for (x<- g2(d).keySet) {
      reachable(x, g2, r)
    }
  }

  def remove(g: Map[String, Map[String, Int]], src: String, dest: String) {
    val d = g(src)
    val v = d(dest)
    if (v == 1) {
      d -= dest
    } else {
      d(dest) = v - 1
    }
    if (d.isEmpty) {
      g -= src
    }
  }
}