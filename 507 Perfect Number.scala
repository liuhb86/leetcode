import scala.math.sqrt
object Solution {
    def checkPerfectNumber(num: Int): Boolean = {
        if (num  <= 1) return false
        val u = sqrt(num).toInt
        var s = 0
        for (i<- 1 to u) {
            if (num % i == 0) {
                s += ( i + num/i)
            }
        }
        s == num + num
    }
}