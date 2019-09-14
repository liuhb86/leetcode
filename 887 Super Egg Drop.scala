// a(N,K) = min max(a(i-1, K-1), a(N-i, K)) + 1
// a(0, x) = 0, a(x, 1) = x

object Solution {
    def superEggDrop(K: Int, N: Int): Int = {
        var dp = (0 to N).toArray
        var dp1 = new Array[Int](N+1)
        for (k<-2 to K) {
            dp1(0) = 0
            var j = 0
            for (i<-1 to N) {
                while(j < i-1 && dp1(j) < dp(i-j-1)) j+=1
                dp1(i) = dp1(j) + 1
                //println(k, i, j, dp1(i))
            }
            val t = dp; dp = dp1; dp1 = t
        }
        dp(N)
    }
}