import scala.collection.mutable.Map
object Solution {
  def commonChars(A: Array[String]): List[String] = {
    val s = Map(A.head.groupBy(identity).mapValues(_.length).toSeq:_*)
    for (x<-A.tail) {
      val m = x.groupBy(identity)
      for ((c, a) <- m) {
        if (s.contains(c)) s(c) = a.length.min(s(c))
      }
      s.retain((c,v) => v > 0 && m.contains(c))
    }
    s.toList.flatMap(x => List.fill(x._2)(x._1.toString))
  }
}