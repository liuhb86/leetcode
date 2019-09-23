// peek
object Solution {
    def nthUglyNumber(n: Int, _a: Int, _b: Int, _c: Int): Int = {
        val (a,b,c) = (_a.toLong, _b.toLong, _c.toLong)
        val ab = lcm(a,b)
        val ac = lcm(a,c)
        val bc = lcm(b,c)
        val abc = lcm(ab, c)
        //println(ab,ac,bc,abc)
        var begin = 2L
        var end = 2000000001L
        while (begin < end) {
            val mid = begin + (end-begin) / 2
            val count = mid/a + mid/b+ mid/c-mid/ab-mid/bc-mid/ac+mid/abc
            if (count < n) {
                begin = mid + 1  
            } else if (count > n) {
                end = mid
            } else {
                return (mid/a*a).max(mid/b*b).max(mid/c*c).toInt
            } 
        }
        throw new Exception(begin.toString)
    }
    
    def gcd(_a: Long, _b: Long) : Long = {
        var a = _a; var b = _b;
        while (b>0) {
            val r = a % b
            a = b
            b = r
        }
        a
    }
    
    def lcm(a: Long, b: Long) : Long = {
        val g = gcd(a,b)
        a / g * b
    }
}