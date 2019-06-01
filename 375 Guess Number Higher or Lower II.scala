import scala.math.max
object Solution {
  def getMoneyAmount(n: Int): Int = {
    val dp = new Array[Array[Int]](n + 1)
    dp(0) = new Array[Int](n + 2)
    dp(1) = new Array[Int](n + 1)
    for (k <- 2 to n) {
      dp(k) = new Array[Int](n-k+2)
      for (i<- 1 to n - k + 1) {
        dp(k)(i) = (i until i + k)
          .map(x=> x + max(dp(x-i)(i), dp(i+k-x-1)(x+1))).min
      }
    }
    dp(n)(1)
  }
}