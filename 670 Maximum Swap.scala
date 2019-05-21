object Solution {
    def maximumSwap(num: Int): Int = {
        swap(num.toString).toInt
    }
    
    def swap(s: String) : String = {
        val md = s.max
        val fnmd = s.indexWhere(_ != md)
        if (fnmd == -1) return s
        val lmd = s.lastIndexOf(md)
        if (fnmd > lmd) return s.take(fnmd) + swap(s.drop(fnmd))
        val t = s.toArray
        t(lmd) = t(fnmd)
        t(fnmd) = md
        t.mkString
    }
}