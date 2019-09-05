//peek
import scala.collection.mutable.Map
object Solution {
    def findNumOfValidWords(words: Array[String], puzzles: Array[String]): List[Int] = {
        val b = Map[Int, Int]()
        for (word<-words) {
            var m = 0
            for(c<-word) {
                m |= 1 << (c-'a')
            }
            b(m)  = b.getOrElse(m, 0) + 1
        }
        puzzles.map(sat(b, _)).toList
        
    }
    
    def sat(b: Map[Int, Int], p: String) : Int = {
        val m0 = 1 << (p(0) - 'a')
        var r = 0
        for (i<-0 until 64) {
            var m = m0
            for (j<-0 until 6) {
                m |= ((i & (1<<j)) >> j) << (p(j+1) -'a')
            }
            r += b.getOrElse(m, 0)
        }
        r
    }
}