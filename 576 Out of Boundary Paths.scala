object Solution {
    val M = 1000000007
    def findPaths(m: Int, n: Int, N: Int, i: Int, j: Int): Int = {
        var dp1=Array.ofDim[Int](m,n)
        var dp2=Array.ofDim[Int](m,n)
        for (s<-1 to N) {
            for (x<-0 until m;y<-0 until n) {
                var c = 0L
                c+= (if (x==0) 1 else dp1(x-1)(y))
                c+= (if (x==m-1) 1 else dp1(x+1)(y))
                c+= (if(y==0) 1 else dp1(x)(y-1))
                c+= (if (y==n-1) 1 else dp1(x)(y+1))
                dp2(x)(y) = (c % M).toInt
            }
            val t = dp1; dp1=dp2; dp2 =t
        }
        dp1(i)(j)
    }
}