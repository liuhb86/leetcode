import scala.math.{sqrt, floor}
object Solution {
    def arrangeCoins(n: Int): Int = {
        // (1+k)*k/2 = n, k*k +k -2n = 0, k = (-1+sqrt(1+8n))/2
        floor((sqrt(n.toDouble * 8 + 1) -1)/2).toInt
    }
}