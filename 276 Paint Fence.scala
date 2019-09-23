object Solution {
    def numWays(n: Int, k: Int): Int = {
        if (n==0 || k==0) return 0
        if (n==1) return k
        if (k==1 && n==2) return 1
        if (k==1) return 0
        var r1 = k
        var r2 = 0
        for (i<-2 to n) {
            val nr1 = (r1+r2)*(k-1)
            r2 = r1
            r1 = nr1
        }
        r1+r2
    }
}