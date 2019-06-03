object Solution {
  def maxWidthRamp(A: Array[Int]): Int = {
    if (A.isEmpty) return 0
    val s = scala.collection.mutable.ArrayBuffer[(Int, Int)]()
    s += ((A.head, 0))
    var p = 0
    var m = 0
    for (j<-1 until A.length) {
      val v = A(j)
      if (v>=s(p)._1) {
        while(p>0 && v>=s(p-1)._1) p-=1
        m = scala.math.max(m, j-s(p)._2)
      } else {
        if (v < s.last._1) s+=((v, j))
        if (p < s.length -1) p += 1
      }
    }
    m
  }
}