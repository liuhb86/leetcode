import scala.collection.mutable.{Map, ArrayBuffer}
object Solution {
    def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
        val map = Map[String, Node]()
        for (((a::b::Nil), v) <- equations.zip(values)) {
            val na = map.getOrElseUpdate(a, new Node())
            val nb = map.getOrElseUpdate(b, new Node())
            val ra = na.getRoot()
            val rb = nb.getRoot()
            if (ra != rb) {
                ra.parent = rb
                // a/b=v a/ra= rna b/rb=rnb ra/rb= rnb/rna * v
                ra.ratio = nb.ratio / na.ratio * v
            }
        }
        val r = new ArrayBuffer[Double](queries.length)
        for (a::b::Nil <- queries) {
            val na = map.getOrElse(a, new Node())
            val nb = map.getOrElse(b, new Node())
            val ra = na.getRoot()
            val rb = nb.getRoot()
            if (ra != rb) {
                r += -1.0
            } else {
                r += na.ratio / nb.ratio
            }
        }
        r.toArray
    }
}

class Node {
    var parent : Node = this
    var ratio = 1.0
    def getRoot() : Node = {
        if (parent == this) return this
        val r = parent.getRoot()
        ratio = ratio * parent.ratio
        parent = r
        r
    }
}