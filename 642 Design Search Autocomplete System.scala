import scala.collection.mutable.{TreeSet, Map, StringBuilder}
class AutocompleteSystem(_sentences: Array[String], _times: Array[Int]) {
    val st = Map[String, Int]()
    var root = new Node()
    val cur = new StringBuilder()
    var cp = root
    
    for ((s,t) <- _sentences.zip(_times)) {
        st(s) = t
        add(s, t, false)
    }
    
    def add(s: String, t: Int, rm: Boolean) = {
        val mt = -t
        val ot = 1-t
        var p = root
        for (c<-s) {
            p = p(c)
            if (rm) p.freq -= ((ot, s))
            p.freq += ((mt, s))
        }
    }
    
    def add() {
        val s = cur.toString
        cur.clear()
        cp = root
        val t = st.get(s)
        if (t.isDefined) {
            st(s) += 1
            add(s, t.get + 1, true)
        } else {
            st(s) = 1
            add(s, 1, false)
        }
    }
    
    def input(c: Char): List[String] = {
        if (c == '#') {add(); return Nil}
        cur += c
        cp = cp(c)
        cp.freq.toIterator.take(3).map(_._2).toList
    }

}

class Node() {
    val children = new Array[Node](27)
    val freq = TreeSet[(Int, String)]()
    def apply(c: Char) : Node = {
        val x = if (c==' ') 26 else c - 'a'
        if (children(x) == null) children(x) = new Node()
        children(x)
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * var obj = new AutocompleteSystem(sentences, times)
 * var param_1 = obj.input(c)
 */