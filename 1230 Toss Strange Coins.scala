object Solution {
    def probabilityOfHeads(prob: Array[Double], target: Int): Double = {
        if (target > prob.length / 2) return probabilityOfHeads(prob.map(1 - _), prob.length - target)
        var dp = new Array[Double](prob.length)
        var p0 = 1.0
        for (i<-prob.indices) {
            dp(i) = p0* prob(i)
            p0 *= 1-prob(i)
        }
        if (target == 0) return p0
        var dp2 = new Array[Double](prob.length)
        for (k<-2 to target) {
            for (i<- k-1 until prob.length) {
                var r = 0.0
                var p = 1.0
                for (j<- i-1 to k-2 by -1) {
                    r += dp(j) * p * prob(i)
                    p *= (1-prob(j))
                }
                dp2(i) = r
            }
            val t = dp; dp=dp2;dp2=t
        }
        var r = 0.0
        var p = 1.0
        for (i<-prob.length -1 to target -1 by -1) {
            r += dp(i) * p
            p *= 1-prob(i)
        }
        r
    }
}