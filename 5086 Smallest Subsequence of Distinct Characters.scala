import scala.collection.mutable.{SortedSet, StringBuilder}
import scala.util.control.Breaks._
object Solution {
    def smallestSubsequence(text: String): String = {
        val left = SortedSet(text:_*)
        val r = new StringBuilder()
        val n = left.size
        val sa = new Array[Set[Char]](text.length)
        var is = Set[Char]()
        var i = text.length -1
        while (is.size != n) {
            val c = text(i)
            is = is + c
            sa(i) = is
            i -= 1
        }
        i += 1
        var j = 0
        while (left.nonEmpty) {
            breakable{
                for (c<-left) {
                    val k = text.indexOf(c, j)
                    if (k<i || left.subsetOf(sa(k))) {
                        r += c
                        j = k+1
                        left -= c
                        break
                    }
                }
            }
        }
        r.toString
    }
}