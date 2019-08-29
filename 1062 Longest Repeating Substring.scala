object Solution {
    def longestRepeatingSubstring(S: String): Int = {
        var r = 0
        val set = scala.collection.mutable.Set[Slice]()
        for (i<-S.indices) {
            var h = 0
            for (j<-i until S.length) {
                h = h * 31 + S(j)
                val c = new Slice(S, i, j, h)
                if (!set.add(c)) {
                    r = r.max(j-i+1)
                }
            }
        }
        r
    }
}

class Slice(val s: String, val i: Int, val j: Int, val h: Int) {
    override def equals(y: Any) : Boolean = {
        y match {
            case x: Slice =>
                if (this eq x) return true
                if (j-i != x.j-x.i) return false
                if (h != x.h) return false
                for (k<-0 to j-i) {
                    if (s(i+k) != x.s(x.i+k)) return false
                }
                true
            case _ => false
        }
    }
    
    override def hashCode() : Int = h
}