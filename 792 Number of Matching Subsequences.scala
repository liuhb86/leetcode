object Solution {
    def numMatchingSubseq(S: String, words: Array[String]): Int = {
        words.count(isSub(S, _))
    }
    
    def isSub(s: String, w: String) : Boolean = {
        if (w.length > s.length) return false
        var i = 0
        for (c<-w) {
            val p = s.indexOf(c, i)
            if (p<0) return false
            i = p+1
        }
        true
    }
}