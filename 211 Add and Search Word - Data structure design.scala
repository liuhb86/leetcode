import scala.collection.mutable.{Map, Set, ArrayBuffer}
class WordDictionary() {

    /** Initialize your data structure here. */
    //val wordList = ArrayBuffer[String]() 
    val wordSet = Set[String]()
    val indexes = Map[Int,Map[(Char, Int), Set[Int]]]()

    /** Adds a word into the data structure. */
    def addWord(word: String) {
        if (wordSet(word)) return
        wordSet += word
        val k = wordSet.size
        val index = indexes.getOrElseUpdate(word.length, Map())
        for (c <- word.zipWithIndex) {
            index.getOrElseUpdate(c, Set()) += k
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    def search(word: String): Boolean = {
        if (!indexes.contains(word.length)) return false
        val index = indexes(word.length)
        val filters = word.zipWithIndex
            .filter(_._1 != '.')
            .map(c => index.getOrElse(c, Set()))
            .sortBy(_.size)
        if (filters.isEmpty) return true
        filters.reduceLeft(_ intersect _).nonEmpty
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */