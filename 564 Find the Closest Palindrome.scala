import scala.math.BigInt
object Solution {
  def nearestPalindromic(n: String): String = {
    var lower = nearest(n, true)
    var upper : String = null
    if (lower == n) {
      lower = nearest((BigInt(n) -1).toString, true)
      upper = nearest((BigInt(n) + 1).toString, false)
    } else {
      upper = nearest(n,false)
    }
    if (BigInt(upper) - BigInt(n) < BigInt(n) - BigInt(lower)) {
      upper
    } else {
      lower
    }
  }

  def nearest(n: String, lower: Boolean) : String = {
    nearest(n.toArray, lower).mkString
  }

  def nearest(n: Array[Char], lower: Boolean) : Array[Char] = {
    val l = n.length
    var c = if (l %2==0) l/2-1 else l/2
    var i = l/2-1
    var j = c+1
    while (i>=0) {
      if (n(i)!=n(j)) {
        if (lower) {
          if (n(j) > n(i)) {
            while(i>=0) {n(j) = n(i); i-=1;j+=1}
            return n
          } else {
            while(n(c)=='0') {c-=1}
            n(c) = (n(c) -1).toChar
            for (i<-c+1 until n.length) n(i) = '9'
            return nearest(BigInt(n.mkString).toString.toArray, lower)
          }
        } else {
          if (n(j) < n(i)) {
            while(i>=0) {n(j) = n(i); i-=1;j+=1}
            return n
          } else {
            while(n(c)=='9') {c-=1}
            n(c) = (n(c) +1).toChar
            for (i<-c+1 until n.length) n(i) = '0'
            return nearest(n, lower)
          }
        }
      }
      i-=1; j+=1
    }
    n
  }

}