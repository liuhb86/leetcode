object Solution {
  def isNStraightHand(hand: Array[Int], W: Int): Boolean = {
    if (hand.length % W != 0) return false
    val s = hand.groupBy(identity).map( x=> Array(x._1, x._2.length)).toArray.sortBy(_(0))
    var i = 0
    while(true) {
      while (i< s.length && s(i)(1) == 0) i += 1
      if (i == s.length) return true
      for (j <- 0 until W) {
        if (i+j < s.length && s(i+j)(0) == s(i)(0) +j && s(i+j)(1) > 0) {
          s(i+j)(1) -= 1
        } else {
          return false
        }
      }
    }
    throw new Exception()
  }
}