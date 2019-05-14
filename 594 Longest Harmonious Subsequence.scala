import scala.collection.mutable.{Map, Set}
object Solution {
    def findLHS(nums: Array[Int]): Int = {
        val map = Map[Long, Int]()
        val s = Set[Long]()
        val s1 = Set[Long]()
        for (n <- nums) {
            s += n
            s1 += (n + 1)
            map(n) = map.getOrElse(n, 0) + 1
            map(n+1) = map.getOrElse(n+1, 0) + 1
        }
        val s2 = (s intersect s1)
        if (s2.isEmpty) 0
        else s2.toSeq.map(map(_)).max
    }
}