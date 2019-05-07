
object Solution {
    def reorganizeString(S: String): String = {
        val count = new Array[Int](26)
        S.foreach(c => count(c - 'a') += 1)
        val rank = count.zipWithIndex.sortBy(_._1).map(_._2).reverse
        var last = -1
        val result = new StringBuilder
        for (i <- 0 until S.length) {
            var r = if (rank(0) != last) 0 else 1
            val c = rank(r)
            if (count(c) == 0) return ""
            
            result += ('a' + c).toChar
            count(c) -= 1
            val countC = count(c)
            while (r <25 && countC < count(rank(r+1))) {
                rank(r) = rank(r+1)
                r += 1
            }
            rank(r) = c
            last = c
        }
        result.toString
    }
}