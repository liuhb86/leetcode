object Solution {
    def PredictTheWinner(nums: Array[Int]): Boolean = {
        // sum(i, L) = sum(i, L-1) + a(i+L-1)
        // dp(i, L) = max( a(i) + sum(i+1, L-1) - dp(i+1, L-1),
        //                a(i+L-1) + sum(i, L-1) - dp(i, L-1)
        // sum(i, 1) = a(i+L-1) , dp(i, 1) = a(i+L-1)
        var dp = nums.map(identity)
        var sum = nums.map(identity)
        var dp2 = new Array[Int](nums.length)
        var sum2 = new Array[Int](nums.length)
        for (L<-2 to nums.length) {
            for (i<-0 to nums.length - L) {
                sum2(i) = sum(i) + nums(i + L -1)
                dp2(i) = (nums(i) + sum(i+1) - dp(i+1)).max(
                          nums(i+L-1) + sum(i) - dp(i))
            }
            val t = dp; dp = dp2; dp2 = t
            val u = sum; sum = sum2; sum2 = u
            //println(dp.mkString(" "))
            //println(sum.mkString(" "))
        }
        dp(0) >= sum(0) - dp(0)
    }
}