import scala.collection.mutable
object Solution {
    def wordPattern(pattern: String, str: String): Boolean = {
        val words = str.split(" ")
        if (words.length != pattern.length) return false
        val map = mutable.Map[Char, String]()
        val wordSet = mutable.Set[String]()
        for ((p, w) <- pattern.zip(words)) {
            val matchedWord = map.get(p)
            if (matchedWord.isDefined) {
                if (matchedWord.get != w) return false
            } else {
                if (wordSet.contains(w)) return false
                map(p) = w
                wordSet += w
            }
        }
        true
    }
}