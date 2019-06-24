object Solution {
    def findNthDigit(n: Int): Int = {
        var d = 1L
        var p = 1L
        var sd = p * 9 *d
        var x = n.toLong
        while (x>sd) {
            x -= sd
            p *= 10
            d += 1
            sd = p* 9 *d
            
        }
        val y = (x-1) / d
        val k = (x-1) % d
        (p + y).toString.apply(k.toInt) - '0'
    }
}