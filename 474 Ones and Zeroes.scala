import scala.math.max
object Solution {
  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    new Solver(strs, m,n).solve()
  }
}

class Solver(strs: Array[String], m: Int, n: Int) {
  val cache = scala.collection.mutable.Map[(Int, Int, Int), Int]()
  val L = strs.length
  val s = strs.map(s=> (s.length, s.count(_=='0')))
    .sortBy(_._1).map(x=> (x._2, x._1-x._2))

  def solve() : Int = {
    solve(0, 0, 0, m , n)
  }

  def solve(i: Int, count: Int, maxC: Int, a: Int, b: Int) : Int = {
    if (i >= L) return count
    if (count + L - i <= maxC) return count
    val (zero, one) = s(i)
    if (zero+one > a+b) return count
    val cv = cache.get((i, a,b))
    if (cv.isDefined) return cv.get
    var c1 = 0
    if (zero <= a && one<=b) {
      c1 = solve(i+1, count+1, maxC, a-zero, b-one)
    }
    val c0 = solve(i+1, count, max(maxC, c1), a,b)
    val c = max(c0,c1)
    cache((i,a,b)) = c
    c
  }
}