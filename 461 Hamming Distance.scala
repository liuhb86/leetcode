object Solution {
    def hammingDistance(x: Int, y: Int): Int = {
        var n = x ^ y
        var d = 0
        while (n > 0) {
            d += n & 1
            n >>= 1
        }
        d
    }
}