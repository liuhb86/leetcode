import scala.math.max
object Solution {
    def maxDistToClosest(seats: Array[Int]): Int = {
        val first = seats.indexOf(1)
        var maxDist = first
        val last = seats.lastIndexOf(1)
        maxDist = max(maxDist, seats.length - last - 1)
        var runningSpace = 0
        var maxSpace = 0
        for (i<-first to last) {
            if (seats(i) == 1) {
                if (runningSpace > maxSpace) maxSpace = runningSpace
                runningSpace = 0
            } else {
                runningSpace += 1
            }
        }
        max(maxDist, (maxSpace + 1) / 2)
    }
}