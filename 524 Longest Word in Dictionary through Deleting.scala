object Solution {
    def findLongestWord(s: String, d: List[String]): String = {
        val sorted = d.sortBy(x=>(-x.length, x))
        for (x<-sorted) {
            if (sat(x,s)) return x
        }
        ""
    }
    
    def sat(x: String, s:String) : Boolean = {
        var i = 0
        for (c<-x) {
            val p = s.indexOf(c, i)
            if (p<0) return false
            i = p + 1
        }
        true
    }
}