import scala.math.max
object Solution {
    def shipWithinDays(weights: Array[Int], D: Int): Int = {
        val sum = weights.sum
        var lb = max(weights.max, sum / D)
        var rb = sum
        while (rb > lb) {
            //println(s"$lb,$rb")
            val mid = (lb + rb) / 2
            val days = ship(weights, mid)
            //println(s"-$mid:$days")
            if ( days <= D) {
                rb = mid
            } else {
                lb = mid + 1
            }
        }
        lb
    }
    
    def ship(weights: Array[Int], capacity: Int) : Int = {
        var leftCapacity = 0
        var days = 0
        for (w <- weights) {
            if (w > leftCapacity) {
                days += 1
                leftCapacity = capacity
            }
            leftCapacity -= w
        }
        days
    }
}