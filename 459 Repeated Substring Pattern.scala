import scala.util.control.Breaks._
object Solution {
    def repeatedSubstringPattern(s: String): Boolean = {
        for (d<- 1 until s.length if s.length % d == 0) {
            var i = d
            var isMatch = true
            breakable { for (g<- 1 until s.length / d; j<- 0 until d) {
                if (s(i) != s(j)) {isMatch = false; break}
                i += 1
            }}
            if (isMatch) return true
        }
        false
    }
}