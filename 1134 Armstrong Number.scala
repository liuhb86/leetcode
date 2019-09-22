import scala.math.pow
object Solution {
    def isArmstrong(N: Int): Boolean = {
        val s = N.toString
        s.map(c=> pow(c - '0', s.length)).sum == N
    }
}