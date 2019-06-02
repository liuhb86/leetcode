import scala.math.{max, min}
object Solution {
  def gcdOfStrings(str1: String, str2: String): String = {
    if (str1.isEmpty || str2.isEmpty) return ""
    val g = gcd(str1.length, str2.length)
    if (str1.substring(0,g) == str2.substring(0, g)) {
      val s = str1.substring(0,g)
      if (str1 != s * (str1.length/g)) return ""
      if (str2 != s* (str2.length/g)) return ""
      return s
    }
    ""
  }

  def gcd(_a: Int, _b: Int) : Int = {
    var a = max(_a,_b)
    var b = min(_a,_b)
    while (b > 1) {
      val t = a % b
      a = b
      b = t
    }
    a
  }
}