import scala.collection.mutable.{Set, ListBuffer}
object Solution {
  def canMeasureWater(x: Int, y: Int, z: Int): Boolean = {
    val solver = new Solver(x, y, z)
    solver.solve()
  }
}

class Solver(x: Int, y: Int, z: Int) {
  val v = Set[(Int, Int)]()
  val q = ListBuffer[(Int, Int)]()

  def solve(): Boolean = {
    solve(0,0)
    while (q.nonEmpty) {
      val (a, b) = q.head
      //print(s"\n($a,$b): ")
      q.trimStart(1)
      if (a == z || b == z || a +b == z) return true
      if (a != 0) solve(0, b)
      if (b != 0) solve(a, 0)
      if (a != x) {
        solve(x, b)
        if (b != 0) {
          if (a + b < x) solve(a + b, 0)
          else solve(x, a + b - x)
        }
      }

      if (b != y) {
        solve(a, y)
        if (a != 0) {
          if (a + b < y) solve(0, a + b)
          else solve(a + b - y, y)
        }
      }
    }
    false
  }

  def solve(a: Int, b: Int) {
    if (!v.contains((a, b))) {
      //print(s"($a,$b) ")
      v += ((a, b))
      q += ((a, b))
    }
  }
}