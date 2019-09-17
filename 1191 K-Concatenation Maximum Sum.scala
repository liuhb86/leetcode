object Solution {
    val M  = 1000000007
    def kConcatenationMaxSum(arr: Array[Int], k: Int): Int = {
        var msb = 0L
        var ms = 0L
        var mins = 0L
        var s = 0L
        for (n<-arr) {
            s += n
            msb = msb.max(s)
            ms = ms.max(s-mins)
            mins = mins.min(s)
        }
        println(s, ms, msb)
        if (k==1) return ms.toInt
        var mse = 0L
        var sr = 0L
        for (n<-arr.reverse) {
            sr += n; mse = mse.max(sr)
        }
        println(mse)
        var r = msb + mse
        if (s>0) r+= (k-2) * s
        r = r.max(ms)
        (r % M).toInt
    }
}