object Solution {
  def numSubmatrixSumTarget(matrix: Array[Array[Int]], target: Int): Int = {
    val m = matrix.map(sum)
    var result = 0
    for(r0 <- 0 until m.length) {
      var s = new Array[Int](m(r0).length +1)
      for (r1<-r0 until m.length) {
        s = s.zip(m(r1)).map(x=> x._1 + x._2)
        val map = scala.collection.mutable.Map[Int, Int]()
        for (t<-s) {
          val c = map.getOrElse(t-target, 0)
          result += c
          map(t) = map.getOrElse(t, 0) + 1
        }
      }
    }
    result
  }

  def sum(a: Array[Int]) : Array[Int] = {
    val r = new Array[Int](a.length + 1)
    r(0) = 0
    for (i<-0 until a.length) {
      r(i+1) = r(i) + a(i)
    }
    r
  }
}