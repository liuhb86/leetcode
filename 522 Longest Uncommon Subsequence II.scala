import scala.collection.mutable.ArrayBuffer
object Solution {
    def findLUSlength(strs: Array[String]): Int = {
        val c = strs.groupBy(identity).mapValues(_.length).toArray.sortBy(-_._1.length)
        val x = new ArrayBuffer[String]()
        for ((s, d)<- c) {
            if (d > 1) {
                x += s
            } else {
                if (!x.exists(t=> isSub(s,t))) return s.length
                x += s
            }
        }
        -1
    }
    
    def isSub(s: String, t: String) : Boolean = {
        var i = 0
        var j = 0
        while (i<s.length && j < t.length) {
            if (s(i) == t(j)) i+=1
            j+=1
        }
        i == s.length
    }
}