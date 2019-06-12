import scala.collection.mutable.Map
object Solution {
    def wordSubsets(A: Array[String], B: Array[String]): List[String] = {
        val s = Map[Char, Int]()
        for (b<-B) {
            val sb = b.groupBy(identity)
            for ((c, x) <- sb) {
                s(c) = s.getOrElse(c, 0).max(x.length)
            }
        }
        
        def f(a: String): Boolean = {
            val sa = a.groupBy(identity)
            for ((c, x) <- s) {
                if (!sa.contains(c)) return false
                if (sa(c).length < x) return false
            }
            true
        }
        
        A.filter(f).toList
    }
}