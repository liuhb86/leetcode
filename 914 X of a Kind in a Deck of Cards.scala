import scala.annotation.tailrec
import scala.collection.mutable.Map

object Solution {
    def hasGroupsSizeX(deck: Array[Int]): Boolean = {
        val map = Map[Int, Int]()
        for (c <- deck) {
            if (map.contains(c)) map(c) += 1
            else map += (c -> 1)
        }
        var x = 0
        for ((k,v) <- map) {
            if (x == 0) x = v
            else x = gcd(x, v)
        }
        x >= 2
    }
    
    @tailrec
    def gcd(x: Int, y: Int): Int = {
        if (y == 0) x
        else gcd(y, x % y)
    }
}