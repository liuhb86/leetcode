import scala.math.{max, min}
object Solution {
    def findSubstringInWraproundString(p: String): Int = {
        val s = new Array[Int](26)
        var i = 0
        while (i < p.length) {
            val c = p(i) - 'a'
            var e = c
            var j = i
            while (j < p.length && p(j) - 'a' == e) {
                e += 1
                if (e == 26) e = 0
                j += 1
            }
            val k = j - i
            for (z<-0 until min(k, 26)) {
                val x = p(i + z) - 'a'
                s(x) = max(s(x), k - z)
            }
            i = j
        }
        s.sum
    }
}