import scala.util.control.Breaks._
object Solution {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    var r :List[Int] = Nil
    for (n<-right to left by -1) {
      var t = n
      breakable{
        while (t > 0) {
          val c = t %10
          t = t / 10
          if (c== 0 || n % c != 0) break
        }
        r = n :: r
      }
    }
    r
  }
}