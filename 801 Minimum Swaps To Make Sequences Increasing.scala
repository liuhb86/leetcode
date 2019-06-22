object Solution {
    def minSwap(A: Array[Int], B: Array[Int]): Int = {
        val M = A.length + 10
        var x = 1
        var nx = 0
        for (i<- 1 until A.length) {
            var inx = M
            if (A(i) > A(i-1) && B(i) > B(i-1)) inx = nx
            if (A(i) > B(i-1) && B(i) > A(i-1)) inx = inx.min(x)
            var ix = M
            if (A(i) > B(i-1) && B(i) > A(i-1)) ix = nx + 1
            if (A(i) > A(i-1) && B(i) > B(i-1)) ix = ix.min(x + 1)
            x = ix
            nx = inx
        }
        x.min(nx)
    }
}