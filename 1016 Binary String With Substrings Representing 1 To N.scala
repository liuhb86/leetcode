object Solution {
    def queryString(S: String, N: Int): Boolean = {
        if (N>S.length) return false
        var k = 0
        var n = N
        while (n>0) {n>>=1; k+=1}
        val r = new Array[Boolean](N+1)
        r(0) = true
        for (i<-1 to k.min(S.length)) {
            var d = 0
            val mask = (1 << i) - 1
            for (j<-0 until i-1) {
                d = (d << 1)  + (S(j)-'0')
            }
            for (j<-i-1 until S.length) {
                d = ((d << 1) + (S(j)-'0')) & mask
                if (d<=N) r(d) = true
            }
        }
        r.forall(identity)
    }
}