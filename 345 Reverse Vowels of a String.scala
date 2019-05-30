object Solution {
  val v = "aeiouAEIOU".toSet
  def reverseVowels(s: String): String = {
    val r = s.toArray
    var i = 0
    var j = s.length - 1
    while (true) {
      while(i < r.length && !v.contains(r(i))) i += 1
      while(j >= 0 && !v.contains(r(j))) j -= 1
      if (i>=j) return r.mkString
      val t = r(i); r(i)= r(j); r(j)=t
      i+= 1
      j -=1
    }
    null
  }
}