object Solution {
    def countCharacters(words: Array[String], chars: String): Int = {
        val d = new Array[Int](26)
        for (c<-chars) d(c-'a') += 1
        def good(w: String) : Boolean = {
            for ((c, x) <- w.groupBy(identity)) {
                if (d(c-'a') < x.length) return false
            }
            true
        }
        words.filter(good).map(_.length).sum
    }
}