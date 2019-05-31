object Solution {
  def minFallingPathSum(A: Array[Array[Int]]): Int = {
    val L = A.length
    var m = A.last
    for (i<-A.length-2 to 0 by -1) {
      val n = new Array[Int](L)
      for (j<-0 until L) {
        var s = m(j)
        if (j >0 && m(j-1)<s) s = m(j-1)
        if (j<L-1 && m(j+1)<s) s= m(j+1)
        n(j) = s + A(i)(j)
      }
      m = n
    }
    m.min
  }
}