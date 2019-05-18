import scala.collection.mutable.StringBuilder
object Solution {
    def toHex(num: Int): String = {
        if (num == 0) return "0"
        var n = num
        val r = new StringBuilder
        for (i <- 1 to 8) {
            if (n == 0) return r.toString.reverse
            val c = n & 0xf
            r += (if (c<10) '0' + c else 'a' + c -10).toChar
            n >>= 4
        }
        r.toString.reverse
    }
}