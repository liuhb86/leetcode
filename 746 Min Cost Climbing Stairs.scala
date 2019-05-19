import scala.math.{min,max}
object Solution {
    def minCostClimbingStairs(cost: Array[Int]): Int = {
        var t1 = 0
        var t2 = 0
        var t = 0
        for (i<- 2 to cost.length) {
            t = min(t1+cost(i-1), t2+ cost(i-2))
            t2 = t1
            t1 = t
        }
        t
    }
}