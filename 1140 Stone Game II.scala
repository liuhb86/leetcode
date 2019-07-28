import scala.collection.mutable.Map
object Solution {
    def stoneGameII(piles: Array[Int]): Int = {
        val map = Map[(Int, Int), Int]()
        val total = piles.sum
        solve(piles, 0, 1, total, map)
    }
    
    def solve(piles: Array[Int], i: Int, M: Int, total: Int, map: Map[(Int, Int), Int]) : Int = {
        if (i == piles.length) return 0
        val c = map.get((i,M))
        if (c.isDefined) return c.get
        var left = total
        var m = 0
        for (j<- i until (i + M*2).min(piles.length)) {
            left -= piles(j)
            val M2 = (j - i + 1).max(M)
            m = m.max(total - solve(piles, j+1, M2, left, map))
        }
        map((i,M)) = m
        m
    }
}