import scala.collection.mutable.ArrayBuffer
import scala.collection.Searching._
import scala.math.{sqrt, ceil}
object Solution {    
    def countPrimes(n: Int): Int = {
        if (n <= 2) return 0 
        val n1 = n - 1
        val isNotPrime = new Array[Boolean](n)
        val upperBound = ceil(sqrt(n1)).toInt
        var nonPrime = 1
        for (i <- 2 +: (3 to upperBound by 2) ) {
            if (!isNotPrime(i)) {
                for (j <- i + i to n1 by i) {
                    if (!isNotPrime(j)) {
                        isNotPrime(j) = true
                        nonPrime += 1
                    }
                }
            }
        }
        n1 - nonPrime
    }
}