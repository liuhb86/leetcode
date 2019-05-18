import scala.util.control.Breaks._
object Solution {
    def maxProduct(words: Array[String]): Int = {
        val t = words.sortBy(-_.length)
            .map(w => (w.toSet, w.length))
        val n = words.length
        var maxLen = 0
        breakable {for (i <- 0 until n - 1) {
            if (t(i)._2 * t(i + 1)._2 <= maxLen) break
            breakable { for (j <- i + 1 until n) {
                val len = t(i)._2 * t(j)._2
                if (len<= maxLen) break
                if (t(i)._1.intersect(t(j)._1).isEmpty) {
                    maxLen = len
                    break
                }
            }}
        }}
        maxLen
    }
}