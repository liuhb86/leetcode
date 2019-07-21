object Solution {
    def mctFromLeafValues(arr: Array[Int]): Int = {
        val n = arr.length
        val dp = Array.ofDim[(Int, Int)](n+1, n)
        for (i<-arr.indices) {
            dp(1)(i) = (0, arr(i))
        }
        for (L <- 2 to n) {
            for (i<-0 to n - L) {
                var m = -1
                var s = -1
                for (r<- i + 1 to i + L -1) {
                    val l1 = r - i; 
                    val l2 = L - l1;
                    val mr = dp(l1)(i)._2.max(dp(l2)(r)._2)
                    val sr = dp(l1)(i)._1 + dp(l2)(r)._1 + dp(l1)(i)._2 * dp(l2)(r)._2
                    if (m < 0) m = mr
                    if (s<0 || sr < s) s = sr
                }
                dp(L)(i) = (s, m)
            }
        }
        //dp.foreach(r=> println(r.mkString(" ")))
        dp(n)(0)._1
    }
}