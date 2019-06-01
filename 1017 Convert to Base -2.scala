// if %2 == 1 then last digit is 1
// +1/-1 >> 1 then alternatively solve with the two seq:
// \sum -(2)^n   &   \sum -(-2)n
object Solution {
  def baseNeg2(N: Int): String = {
    if (N==0) return "0"
    val r = new scala.collection.mutable.StringBuilder
    var n = N
    var c = -1
    while(n >0) {
      if (n % 2 == 0) {
        r += '0'
      } else {
        r += '1'
        n += c
      }
      n >>= 1
      c = -c
    }
    r.toString.reverse
  }
}