import scala.util.Try
object Solution {
  def nextGreaterElement(n: Int): Int = {
    val s = n.toString.toArray
    var i = s.length - 2
    while(i>=0 && s(i) >= s(i+1)) i-=1
    if (i<0) return -1
    val d = s(i)
    val j = s.lastIndexWhere(_>d)
    s(i) = s(j); s(j) = d
    Try{(s.take(i + 1) ++ s.drop(i+1).reverse).mkString.toInt}.getOrElse(-1)
  }
}