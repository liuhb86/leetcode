object Solution {
    def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {
        words.filter(check(_, pattern)).toList
    }
    
    def check(w: String, p:String) : Boolean = {
        val m1 = Array.fill(26)(-1)
        val m2 = Array.fill(26)(-1)
        for (i<- 0 until w.length) {
            val a = w(i) - 'a'
            val b = p(i) - 'a'
            if (m1(a) >= 0) {
                if (m1(a) != b) return false
            } else if (m2(b) >= 0) {
                return false
            } else {
                m1(a) = b
                m2(b) = a
            }
        }
        true
    }
}