import scala.math.{max, min}
object Solution {
  def mincostTickets(days: Array[Int], costs: Array[Int]): Int = {
    val t = new Array[Boolean](366)
    for (d<-days) t(d) = true
    val dp = new Array[Int](366)
    dp(0) = 0
    for (i<- 1 to 365) {
      if (!t(i)) dp(i) = dp(i-1)
      else {
        dp(i) = Array(
          dp(i-1) + costs(0),
          dp(max(i-7,0)) + costs(1),
          dp(max(i-30,0)) + costs(2)
        ).min
      }
    }
    dp(365)
  }
}