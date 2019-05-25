import scala.collection.mutable.ListBuffer
object Solution {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    val result = ListBuffer[List[Int]]()
    solve(k,n,9,Nil, result)
    result.toList
  }

  def solve(k: Int, n: Int, m: Int, current: List[Int], result: ListBuffer[List[Int]]) {
    if (k == 1) {
      if (n <=m && n>0) result += (n :: current)
      return
    }
    if (k > m) return
    val upper = ( 2* m -k + 1) * k /2
    if (n > upper) return
    val lower = (1 + k) *k / 2
    if (n < lower) return
    solve(k, n, m -1, current, result)
    solve(k-1, n-m, m-1, m::current, result)
  }
}