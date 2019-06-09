object Solution {
    def isPerfectSquare(num: Int): Boolean = {
        var n = num
        var k = 1
        while (n>0) {
            n -= k
            k += 2
        }
        n == 0
    }
}