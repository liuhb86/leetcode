import scala.math._
object Solution {
  def reachNumber(target: Int): Int = {
      val t = abs(target).toLong
      // n * (n +1)/2 = t   n2 + n - 2t = 0
      val n = ceil((sqrt(1+8*t)-1)/2).toInt
      val s = n.toLong * (n+1) / 2
      if ((s-t) %2 == 0) n // sum 1 to n, reverse (s-t)
      else if (n % 2 == 0) n + 1  // sum 1 to n +1, reverse (s + n +1 -t)/2
      else n +2 // sum 1 to n + 2 reverse (s+n+1+n+2-t)/2
  }
}