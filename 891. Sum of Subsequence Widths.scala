object Solution {
    val pow2 = new Array[Long] (20001)
    val modulo = 1000000007
    pow2(0) = 1
    var pow2calc = 0
    def sumSubseqWidths(A: Array[Int]): Int = {
        val sorted = A.sorted
        var sum : Long = 0
        val n = A.length
        for (i<-0 until n) {
            val t = (pow(i) - pow(n - i -1))% modulo
            sum = (sum + t * sorted(i)) % modulo
            //println(s"$i,$sum,$t,${pow2(i)}")
        }
        (sum.toInt + modulo) % modulo
    }
    
    def pow(p : Int) : Long = {
        if (p <= pow2calc) return pow2(p)
        var r = pow2(pow2calc)
        while(pow2calc < p) {
            r = (r * 2) % modulo
            pow2calc += 1
            pow2(pow2calc) = r
        }
        r
    }
    
    
}