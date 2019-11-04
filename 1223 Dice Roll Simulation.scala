object Solution {
    val M = 1000000007
    def dieSimulator(n: Int, rollMax: Array[Int]): Int = {
        var dp = Array.ofDim[Int](6, 16)
        for (i<-0 until 6) {
            dp(i)(1) = 1
        }
        var dp2 = Array.ofDim[Int](6,16)
        for (k<-2 to n) {
            for (x<-0 until 6) {
                for (i<-2 to rollMax(x)) {
                    dp2(x)(i) = dp(x)(i-1)
                }
                var r = 0L
                for (y<- 0 until 6 if y!=x) {
                    for (i<-1 to rollMax(y)) {
                        r += dp(y)(i)
                    }
                }
                dp2(x)(1) = (r % M).toInt
            }
            val t = dp; dp = dp2; dp2 = t
        }
        var r = 0L
        for (x<-0 until 6) {
            for (i<-1 to rollMax(x)) {
                r += dp(x)(i)
            }
        }
        (r % M).toInt
    }
}