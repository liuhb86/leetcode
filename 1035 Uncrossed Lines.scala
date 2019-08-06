object Solution {
    def maxUncrossedLines(A: Array[Int], B: Array[Int]): Int = {
        var dp0 = new Array[Int](B.length+1)
        var dp1 = new Array[Int](B.length+1)
        for (i<- 1 to A.length) {
            for (j<-1 to B.length) {
                dp1(j) = if (A(i-1) == B(j-1)) dp0(j-1) + 1
                    else dp0(j).max(dp1(j-1))
            }
            val t = dp0; dp0 = dp1; dp1=t
        }
        dp0(B.length)
    }
}