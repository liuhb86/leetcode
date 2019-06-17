object Solution {
  def atMostNGivenDigitSet(D: Array[String], N: Int): Int = {
    if (N<=0) return 0
    val s = N.toString
    val k = s.length
    val all = new Array[Int](k)
    all(0) = 1
    for (i<-1 until k) all(i) = all(i-1) * D.length
    var total = exact(s, D.map(_.head), all)
    for (i<-1 until k) total += all(i)
    total
  }

  def exact(s: String, D: Array[Char], all: Array[Int]) : Int = {
    if (s.isEmpty) return 1
    val d = s.head
    var total = 0
    for (v<-D) {
      if (v>d) return total
      if (v<d) {
        total += all(s.length -1)
      } else {
        total += exact(s.tail, D, all)
      }
    }
    total
  }
}