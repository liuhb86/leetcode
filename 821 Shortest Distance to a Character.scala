object Solution {
    def shortestToChar(S: String, C: Char): Array[Int] = {
        val m = 30000
        var d = m
        val result = new Array[Int](S.length)
        for (i<- 0 until S.length) {
            if (S(i) == C) d = 0 else d += 1
            result(i) = d
        }
        d = m
        for (i <- S.length - 1 to 0 by -1) {
            if (S(i) == C) d = 0 else d += 1
            result(i) = scala.math.min(result(i), d)
        }
        result
    }
}