import scala.math.max
object Solution {
    def findLUSlength(a: String, b: String): Int = {
        if (a.length != b.length) max(a.length, b.length)
        else if (a != b) a.length
        else -1
    }
}