//peek, reverse thinking, dp
object Solution {
    def maxCoins(nums: Array[Int]): Int = {
        val N = nums.length
        if (N == 0) return 0
        val dp = Array.ofDim[Int](N,N)
        for (L<-1 to N) {
            for (i<-0 to N-L) {
                val j = i + L - 1
                var m = Int.MinValue
                val p = if (i==0) 1 else nums(i-1)
                val q = if (j== N-1) 1 else nums(j+1)
                val pq = p * q
                for (k<-i to j) { // burst k at last.
                    m = m.max(g(dp, i, k-1) + g(dp, k+1, j) + pq*nums(k))
                }
                dp(i)(j) = m
            }
        }
        dp(0)(N-1)
    }
    
    def g(dp: Array[Array[Int]], i: Int, j: Int) : Int = {
        if (i>j) 0
        else dp(i)(j)
    }
}
