object Solution {
    def beautifulArray(N: Int): Array[Int] = {
        if (N==1) return Array(1)
        val r = new Array[Int](N)
        val p = Integer.highestOneBit(N-1)
        val u = (p << 1)
        var j = 0
        for (i<- 0 until u) {
            val k = reverse(i, p)
            //println(i,k)
            if (k<N) {
                r(j) = k + 1
                j +=1
            }
        }
        r
    }
    
    def reverse(_n: Int, _p: Int) : Int =  {
        var  r = 0
        var n = _n
        var p = _p
        while (p>0) {
            r = (r << 1) + (n & 1)
            n >>= 1
            p >>= 1
        }
        r
    }
}