//k, m
//k >=m => max t(m) 
//r(k,m) = min(max(tm, r(k-1,m-1)), split+ r(2k, m))
object Solution {
    def minBuildTime(blocks: Array[Int], split: Int): Int = {
        val sorted = blocks.sorted
        var dp0 = new Array[Int](blocks.length + 1)
        dp0(1) = sorted.head
        var dp = new Array[Int](blocks.length + 1)
        for (m<-2 to blocks.length) {
            dp(m) = sorted(m-1)
            for(k<- m-1 to 2 by -1) {
                dp(k) = sorted(m-1).max(dp0(k-1))
                    .min(split + dp((k*2).min(m)))
            }
            dp(1) = split + dp(2)
            val t = dp0; dp0=dp; dp=t
        }
        dp0(1)
    }
}