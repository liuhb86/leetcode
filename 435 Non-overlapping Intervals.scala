import scala.math.min
object Solution {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    if (intervals.isEmpty) return 0
    val s = intervals.sortBy(_(1))
    val dp = new Array[Int](s.length)
    dp(0) = 0
    for (i <- 1 until s.length) {
      val t = bs(s, s(i)(0), i)
      dp(i) = min(dp(i-1) + 1 ,
        if (t==0) i else dp(t-1) + i-t)
    }
    dp(s.length - 1)
  }

  def bs(s: Array[Array[Int]], v: Int, e: Int) : Int = {
    var begin = 0
    var end = e
    while (begin != end) {
      val mid = (begin + end - 1) /2
      if (s(mid)(1) <= v) {
        begin = mid + 1
      } else {
        end = mid
      }
    }
    begin
  }
}