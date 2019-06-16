object Solution {
    
    def M = 1337L
    
    def superPow(a: Int, b: Array[Int]): Int = {
        // a^(x10^c+ y10^d) = (a^10^c)^x. (a^10^d)^y
        var a10 = a.toLong
        var r = 1L
        for (x<-b.reverse) {
            for (i<-1 to x) {
                r = (r * a10) % M
            }
            a10 = x10(a10)
        }
        r.toInt
    }
    
    def x10(a: Long) : Long= {
        val a2 = (a* a) % M
        val a4 = (a2 * a2) %M
        val a8 = (a4*a4)%M
        (a8*a2)%M
    }
}