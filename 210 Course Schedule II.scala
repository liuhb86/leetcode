import scala.collection.mutable.{Map, Set, ArrayBuffer}
object Solution {
    def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
        val g = Map(prerequisites.groupBy(_(0)).mapValues(x => Set(x.map(_(1)):_*)).toSeq:_*)
        val g2 = prerequisites.groupBy(_(1))
        val r = new ArrayBuffer[Int](numCourses)
        var current = (0 until numCourses).filter(x=> !g.contains(x)).toList
        while (current != Nil) {
            var next: List[Int] = Nil
            for (c<- current) {
                r += c
                if (g2.contains(c)) {
                    for (Array(d, _) <- g2(c)) {
                        g(d) -= c
                        if (g(d).isEmpty) next = d::next
                    }
                }
            }
            current = next
        }
        if (r.length != numCourses) Array() else r.toArray
    }
}