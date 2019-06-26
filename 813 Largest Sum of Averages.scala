object Solution {
    def largestSumOfAverages(A: Array[Int], K: Int): Double = {
        var dp = new Array[Double](A.length)
        var s = 0.0
        for (i<-A.indices) {
            s += A(i)
            dp(i) = s / (i+1)
        }
        //println(dp.mkString(","))
        
        var dp2 = new Array[Double](A.length)
        for (k<- 2 to K) {
            for (i<- k-1 until A.length - (K-k)) {
                var s = A(i).toDouble
                var m = s + dp(i-1)
                for (j<- i-1 to k -1 by -1) {
                    s += A(j)
                    val v = s/(i-j+1) + dp(j-1)
                    //if (k==K && i==6) println(s"$m $v $s ${i-j+1} ${s/(i-j+1)} ${dp(j-1)}")
                    m = m.max(v)
                }
                dp2(i) = m
            }
            val t = dp; dp = dp2; dp2 = t
            //println(dp.mkString(","))
        }
        dp(A.length-1)
    }
}