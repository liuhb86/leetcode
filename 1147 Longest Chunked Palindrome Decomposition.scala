import scala.util.control.Breaks._
object Solution {
    def longestDecomposition(text: String): Int = {
        var i = 0
        var j = text.length - 1
        var r = 0
        while (i< j ) {
            var k = 1
            var found = false
            breakable { while (i+k-1 < j-k+1) {
                var matches = true
                val sj = j-k + 1
                breakable {for (x<-0 until k) {
                    if (text(i+x) != text(sj+x)) {
                        matches = false
                        break
                    }
                }}
                if (matches) {
                    found = true
                    break
                }
                k += 1
            }}
            if (found) {
                r += 2
                i = i+k
                j = j - k
            } else {
                i = j
            }
        }
        if (i==j) r += 1
        r
    }
}