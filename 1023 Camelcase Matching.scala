import scala.collection.mutable.ListBuffer
object Solution {
    def camelMatch(queries: Array[String], pattern: String): Array[Boolean] = {
        queries.map(s => matches(s, pattern))
    }
    
    def matches(s:String, p: String) : Boolean = {
        var i = 0
        var j = 0
        while (i<s.length && j < p.length) {
            if (s(i) == p(j)) {
                i+=1; j+=1
            } else {
                if (s(i).isUpper) return false
                i+=1
            }
        }
        if (j != p.length) return false
        while (i<s.length) {
            if (s(i).isUpper) return false
            i+=1
        }
        true
    }
}