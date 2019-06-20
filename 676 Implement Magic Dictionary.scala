import scala.collection.mutable.{Map,Set}
class MagicDictionary() {

    /** Initialize your data structure here. */
    var map : Map[String, Set[String]] = _

    /** Build a dictionary through a list of words */
    def buildDict(dict: Array[String]) {
        map = Map[String, Set[String]]()
        for (w<-dict) {
            for(i<-0 until w.length) {
                val s = w.take(i) ++ "_" ++ w.drop(i+1)
                val set = map.getOrElseUpdate(s, Set[String]())
                set += w
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    def search(word: String): Boolean = {
        for (i<-0 until word.length) {
            val s = word.take(i) ++ "_" ++ word.drop(i+1)
            if (map.contains(s)) {
                val set = map(s)
                if (set.size > 1 || !set(word)) return true
            }
        }
        false
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = new MagicDictionary()
 * obj.buildDict(dict)
 * var param_2 = obj.search(word)
 */