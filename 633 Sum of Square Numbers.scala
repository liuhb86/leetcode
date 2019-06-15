object Solution {
    def judgeSquareSum(c: Int): Boolean = {
        var i = 1
        var i2 = 0
        var j = scala.math.sqrt(c).toInt
        var j2 = j*j
        j = j * 2 - 1
        while (i2 <= j2) {
            val s = i2+j2
            if (s == c) return true
            else if (s > c) {j2-= j; j-=2}
            else {i2+=i; i+=2}
        }
        false
    }
}