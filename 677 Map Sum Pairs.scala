import scala.collection.mutable.Map
class MapSum() {

    /** Initialize your data structure here. */
    val map = Map[String,Int]()
    val root = new Node()
    

    def insert(key: String, `val`: Int) {
        val v = `val` - map.getOrElse(key, 0)
        map(key) = `val`
        root.sum += v
        var p = root
        for (c<-key) {
            p = p.child.getOrElseUpdate(c, new Node())
            p.sum += v
        }
    }

    def sum(prefix: String): Int = {
        var p = root
        for (c<-prefix) {
            val po = p.child.get(c)
            if (po.isEmpty) return 0
            p = po.get
        }
        p.sum
    }

}

class Node{
    val child = Map[Char, Node]()
    var sum = 0
}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = new MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */