import scala.collection.mutable.{Map, StringBuilder}
object Solution {
  def shortestSuperstring(A: Array[String]): String = {
    val d = Array.ofDim[Int](A.length, A.length)
    for (i<-A.indices; j<-A.indices) {
      d(i)(j) = dis(A(i), A(j))
    }
    //println(d.map(_.mkString(",")).mkString("\n"));println()

    var current = Map[IndexedSeq[Int], Array[(Int, List[Int])]]()
    for (i <- A.indices) {
      current(IndexedSeq(i)) = Array((0, Nil))
    }

    for (L <- 2 to A.length) {
      val next = Map[IndexedSeq[Int], Array[(Int, List[Int])]]()
      for ((k, _) <- current) {
        for (i<- k.last + 1 until A.length) {
          val newk = k :+ i
          next(newk) = new Array[(Int, List[Int])](newk.length)
          for (first<- newk.indices) {
            var m = -1
            var mi = 0
            val kf = newk(first)
            val rest = newk.take(first) ++ newk.drop(first + 1)
            for (second <- rest.indices) {
              val v = d(kf)(rest(second)) + current(rest)(second)._1
              if (m<0 || v<m) {m=v; mi = second}
            }
            next(newk)(first) = (m, rest(mi) :: current(rest)(mi)._2)
          }
        }
      }
      current = next
    }

    var m = -1
    var mi = 0
    val h = current.head._2
    for (i<- A.indices) {
      val v = A(i).length + h(i)._1
      if (m<0|| v<m) {m= v; mi=i}
    }

    val r = new StringBuilder()
    r ++= A(mi)
    var rl = h(mi)._2
    //println((mi::rl).mkString(","))
    while (rl!= Nil) {
      val n = rl.head
      r ++= A(n).takeRight(d(mi)(n))
      mi = n
      rl = rl.tail
    }
    r.toString
  }

  def dis(a: String, b: String) : Int = {
    def s(c: Int) : Boolean = {
      for (i<-0 until c) {
      if (a(a.length - c + i) != b(i)) return false
    }
      true
    }
    for (c<- a.length.min(b.length)-1 to 1 by -1) {
      if (s(c)) return b.length - c
    }
    b.length
  }

}