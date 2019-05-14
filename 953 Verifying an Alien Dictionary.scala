object Solution {
    def isAlienSorted(words: Array[String], order: String): Boolean = {
        val rank = new Array[Int](26)
        for (i<- 0 until order.length) {
            rank(order(i)-'a') = i
        }
        var lastWord = ""
        for (w <- words) {
            val word = w.map{c : Char => ('a' + rank(c-'a')).toChar}
            if (word < lastWord) return false
            lastWord = word
        }
        true
    }
}