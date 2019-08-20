object Solution {
    def shortestDistance(words: Array[String], word1: String, word2: String): Int = {
        var r = words.length
        var i = -1
        var j = -1
        for (k<-words.indices) {
            if (words(k)==word1) {
                i = k
                if (j >=0) r = r.min(i-j)
            } else if (words(k)==word2) {
                j = k
                if (i>=0) r = r.min(j-i)
            }
        }
        r
    }
}