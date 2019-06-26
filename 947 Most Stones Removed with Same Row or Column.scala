import scala.collection.mutable.Map
object Solution {
    def removeStones(stones: Array[Array[Int]]): Int = {
        val row = Map[Int, Node]()
        val col = Map[Int, Node]()
        var groups = 0
        for (Array(x, y)<- stones) {
            val xn = row.get(x)
            val yn = col.get(y)
            //println(groups)
            if (xn.isEmpty && yn.isEmpty) {
                groups += 1
                val g = new Node
                row(x) = g; col(y) = g
            } else if (xn.isDefined && yn.isDefined) {
                val (xd, yd) = (xn.get, yn.get)
                if (xd.getRoot != yd.getRoot) {
                    groups -= 1
                    xd.getRoot.p = yd.getRoot
                }
            } else if (xn.isDefined) {
                col(y) = xn.get.getRoot
            } else {
                row(x) = yn.get.getRoot
            }
        }
        stones.length - groups
    }
}

class Node {
    var p: Node = _
    def getRoot() : Node = {
        if (p == null) return this
        val r = p.getRoot()
        p = r
        r
    }
}