import scala.collection.mutable.Map
object Solution {
  val mp = 1.0/8.0
  val moves = Array(
    (-1,-2),(-1,2),(1,-2),(1,2),
    (-2,-1),(-2,1),(2,-1),(2,1)
  )

  def knightProbability(N: Int, K: Int, r: Int, c: Int): Double = {
    var p = Map[(Int, Int), Double]()
    p((r, c)) = 1
    for (i<- 1 to K) {
      val np = Map[(Int, Int), Double]()
      for (((x,y), p0) <- p) {
        val p1 = p0/8.0
        for ((dx,dy) <-moves) {
          move(N, x +dx, y+dy, p1, np)
        }
      }
      p = np
    }
    p.values.sum
  }

  def move(N: Int, r: Int, c: Int, p0: Double, p: Map[(Int, Int), Double]) : Unit = {
    if (r<0 || r >= N || c<0 || c>=N) return
    p((r,c)) = p.getOrElse((r,c), 0.0) + p0
  }
}