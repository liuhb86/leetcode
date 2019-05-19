import scala.collection.mutable.ListBuffer
object Solution {
    def longestStrChain(words: Array[String]): Int = {
        val sorted = words.sortBy(_.length)
        //println(sorted.mkString(","))
        var curLength = 0
        var prevList : List[(String, Int, List[String])] = Nil
        var curList : List[(String, Int, List[String])] = Nil
        var maxChain = 0
        var maxList : List[String] = Nil
        for (word <- sorted) {
            if (word.length != curLength) {
                if (word.length == curLength + 1) {
                    prevList = curList.sortBy{x => -x._2}
                } else {
                    prevList = Nil
                }
                curLength = word.length
                curList = Nil
            }
            val t = prevList.find{x => isPre(x._1, word)}
            val len = t.map(_._2).getOrElse(0) + 1
            val d = word :: t.map(_._3).getOrElse(Nil)
            if (len > maxChain) {
                maxChain = len
                maxList = d
            }
            curList = (word, len, d) :: curList
        }
        //println(maxList.mkString(","))
        maxChain
    }
    
    def isPre(p: String, w: String) : Boolean = {
        //println(s"$p,$w")
        var skip = false
        var j = 0
        for (i<- 0 until w.length) {
            if (j == p.length || w(i)!=p(j)) {
                //println(s"$i,$j")
                if (skip) return false
                skip = true
            } else {
                j += 1
            }
        }
        true
    }
}