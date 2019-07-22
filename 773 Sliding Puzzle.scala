import scala.util.control.Breaks._
object Solution {
  def slidingPuzzle(board: Array[Array[Int]]): Int = {
    var x = 0
    var y = 0
    var n = 0
    for (i <- 1 to 0 by -1; j <- 2 to 0 by -1) {
      n = (n << 3) | board(i)(j)
      if (board(i)(j) == 0) {
        x = i;
        y = j
      }
    }
    var goal = 0
    for (i <- 5 to 1 by -1) goal = (goal << 3) | i
    var list = List((n, x, y))
    val visited = scala.collection.mutable.Map[Int, Boolean]()
    visited(n) = true
    var r = 0
    while (list != Nil) {
      var next: List[(Int, Int, Int)] = Nil
      for ((n, x, y) <- list) breakable {
        //printn(n)
        if (n == goal) return r
        for (dy <- -1 to 1) breakable {
          val ny = y + dy
          if (ny < 0 || ny >= 3) break
          val nx = if (dy == 0) 1 - x else x
          val g = get(n, nx * 3 + ny)
          val nn = set(g._1, x * 3 + y, g._2)
          if (visited.contains(nn)) break
          visited(nn) = true
          next = (nn, nx, ny) :: next
        }
      }
      r += 1
      list = next
    }
    -1
  }

  def printn(n: Int) {
    var x = n
    for (i<-1 to 6) {
      print(x&7)
      x = x>>3
      print(",")
    }
    println(n)
  }

  def get(n: Int, i: Int) : (Int, Int) = {
    val v = n & (7 << (i*3))
    (n ^ v, v >>(i*3))
  }

  def set(n: Int, i: Int, v: Int) : Int = {
    n | (v << (i*3))
  }
}