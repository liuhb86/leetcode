import scala.collection.mutable.ArrayBuffer
object Solution {
  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
    val t = envelopes.map(x=>(x(0),x(1))).sortBy(x=>(x._1,-x._2)).map(_._2)
    // lis
    val s = ArrayBuffer[Int]()
    for (h<-t) {
      val i = bsearch(s, h)
      if (i==s.length) s+=h else s(i) = h
    }
    s.length
  }

  def bsearch(s: ArrayBuffer[Int], v: Int) : Int = {
    var begin = 0
    var end = s.length
    while(end - begin > 1) {
      val mid = begin + (end-begin -1)/2
      if (s(mid) == v) return mid
      if (s(mid) < v) {
        begin = mid + 1
      } else {
        end = mid
      }
    }
    if (begin == end) return begin
    if (s(begin) >= v) begin else end
  }
}