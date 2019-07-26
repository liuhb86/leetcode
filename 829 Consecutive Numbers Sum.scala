import scala.math.sqrt
object Solution {
    def consecutiveNumbersSum(N: Int): Int = {
        // (x + y) * (y-x+1) / 2 = n
        // p * q   q=x+y p = y-x + 1 x = (q-p +1) / 2  y = (q + p -1) / 2
        val n2 = N*2
        val m = sqrt(n2).toInt
        var  r = 0
        for (i<- 1 to m if n2 % i == 0) {
            val j = n2 / i
            if ((i%2==1 || j%2==1)) r+=1
        }
        r
    }
}