import scala.math.pow
object Solution {
    def integerBreak(n: Int): Int = {
        if (n==2) return 1
        if (n==3) return 2
        (n %3 match {
            case 0 => pow(3, n/3)
            case 1=> pow(3, n/3 - 1) * 4
            case 2=> pow(3, n/3) * 2
        }).toInt
    }
}