import scala.collection.mutable.Map
object Solution {
    def longestWord(words: Array[String]): String = {
        val hash = Map(words.map(w => (w, 0)):_*)
        hash("") = 1
        var r = ""
        for (w<-words) {
            if (w.length > r.length || (w.length ==r.length && w < r)) {
                if (check(w, hash)) r = w
            }
        }
        r
    }
    
    def check(w: String, hash: Map[String, Int]) : Boolean = {
        val v = hash.get(w)
        if (v.isEmpty) return false
        val vv = v.get
        if (vv==1) return true
        if (vv== -1) return false
        val c = check(w.dropRight(1), hash)
        hash(w) = if (c) 1 else -1
        c
    }
}