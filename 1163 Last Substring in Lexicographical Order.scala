import scala.collection.mutable.{ArrayBuffer, Map}
import scala.util.control.Breaks._
object Solution {
    def lastSubstring(s: String): String = {
        val mc = s.max
        val ms = s.zipWithIndex.filter(_._1 == mc).map(_._2).toArray
        val cache = Map[(Int, Int), Boolean]()
        var mi = ms.last
        for (i<-ms.length - 2 to 0 by -1) {
            if (compare(s, ms(i), mi, cache)) {
                mi = ms(i)
            }
        }
        s.substring(mi, s.length)
    }
    
    def compare(s: String, _i: Int, _j: Int, cache: Map[(Int, Int), Boolean]) : Boolean = {
        val ca = cache.get((_i, _j))
        if (ca.isDefined) return ca.get
        val mc = s(_i)
        var i = _i+1
        var j = _j+1
        while(j < s.length && s(i)==s(j) && s(i)!=mc) {
            i += 1; j += 1
        }
        val r = 
            if (j == s.length) {
                true
            } else if (s(i) < s(j)) {
                false
            } else if (s(i) > s(j)) {
                true
            } else {
                compare(s, i, j, cache)
            }
        cache((_i,_j)) = r
        r
    }
}