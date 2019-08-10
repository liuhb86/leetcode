import scala.util.control.Breaks._
object Solution {
    def splitArray(nums: Array[Int], m: Int): Int = {
        var dp = new Array[Long](nums.length)
        dp(0) = nums(0)
        for (i<-1 until nums.length) dp(i) = dp(i-1) + nums(i)
        for (k<- 2 to m) {
            for (i<- nums.length - 1 to k - 1 by -1) {
                var s = 0L
                breakable {for (j<-i to k-1 by -1) {
                    s += nums(j)
                    dp(i) = dp(i).min(s.max(dp(j-1)))
                    if (s > dp(i)) break
                }}
            }
        }
        dp(nums.length -1).toInt
    }
}