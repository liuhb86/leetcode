object Solution {
    val M = 1000000007
    val primes = Set(2,3,5,7,11,13,17,19,23,29 ,31,37,41,43,47,53,59,61,67,71 ,73,79,83,89,97 )
    def numPrimeArrangements(n: Int): Int = {
        val np = (1 to n).count(primes(_))
        val r = (f(np) * f(n-np)) % M
        r.toInt
    }
    
    def f(n: Int) : Long =  {
        var r = 1L
        for (i<-1L to n.toLong) {
            r = (r * i) % M
        }
        r
    }
}