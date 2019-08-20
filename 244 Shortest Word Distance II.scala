class WordDistance(_words: Array[String]) {
    
    val map = scala.collection.mutable.Map[String, List[Int]]()
    
    for (i<-_words.indices) {
        val w = _words(i)
        map(w) = i :: map.getOrElse(w, Nil)
    }

    def shortest(word1: String, word2: String): Int = {
        var r = _words.length
        var p1 = map(word1)
        var p2 = map(word2)
        while(p1.nonEmpty && p2.nonEmpty) {
            if (p1.head < p2.head) {
                r=r.min(p2.head-p1.head)
                p2=p2.tail
            } else {
                r = r.min(p1.head-p2.head)
                p1=p1.tail
            }
        }
        r
    }

}

/**
 * Your WordDistance object will be instantiated and called as such:
 * var obj = new WordDistance(words)
 * var param_1 = obj.shortest(word1,word2)
 */