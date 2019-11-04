object Solution {
    def balancedString(S: String): Int = {
        val cm = Map('Q' -> 0, 'W' -> 1, 'E'->2, 'R' ->3)
        val s = S.map(x=> cm(x))
        val d = s.length / 4
        val g = s.groupBy(identity).mapValues(_.length)
        val t = new Array[Int](4)
        for (i<-0 until 4) {
            val c = g.getOrElse(i, 0)
            if (c > d) t(i) = c-d
        }
        var c = new Array[Int](4)
        if (sat(c,t)) return 0
        var r = s.length
        var j = 0
        for (i<-s.indices) {
            while (!sat(c, t)) {
                if (j == s.length) return r
                c(s(j)) += 1
                j += 1
            }
            r = r.min(j-i)
            c(s(i)) -= 1
        }
        r
    }
    
    def sat(c: Array[Int], t: Array[Int]) : Boolean = {
        for (i<-0 until 4) {
            if (c(i) < t(i)) return false
        }
        true
    }
}