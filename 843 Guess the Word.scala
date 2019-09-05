/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Master {
 *
 *   def guess(word: String): Int = {}
 *
 * }
 */
object Solution {
    def findSecretWord(wordlist: Array[String], master: Master): Unit = {
        var words = wordlist
        while(true) {
            var word: String = null
            var map: Map[Int, Array[String]] = null
            var m = words.length + 1
            for (w <- words) {
                val g = words.groupBy(res(w, _))
                val mi = g.map(_._2.length).max
                if (mi < m) {
                    word = w
                    map = g
                    m = mi
                }
            }
            val r = master.guess(word)
            if (r == 6) return
            words = map(r)
        }
    }
    
    def res(w: String, t: String) : Int = {
        var c = 0
        for (i<-0 until 6 if w(i) == t(i)) c+=1
        c
    }
}