object Solution {
    def shortestWordDistance(words: Array[String], word1: String, word2: String): Int = {
        var p1 = -1
        var p2 = -1
        var r = Int.MaxValue
        val same = (word1 == word2)
        for (i<-words.indices) {
            val w = words(i)
            if (w == word1) {
                if (p2 >=0) r = r.min(i-p2)
                if (same) p2 = i else p1 = i
            } else if (w == word2) {
                if (p1 >=0) r = r.min(i-p1)
                p2 = i
            }
        }
        r
    }
}