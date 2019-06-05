import scala.annotation.tailrec
object Solution {
  def letterCasePermutation(S: String): List[String] = {
    solve(S, List(""))
  }

  @tailrec
  def solve(S: String, p: List[String]) : List[String] = {
    if (S.isEmpty) return p
    val c = S.head
    if (c.isLetter) {
      val u = c.toUpper
      val l = c.toLower
      solve(S.tail, p.map( _ :+ u) ++ p.map(_ :+ l))
    }
    else solve(S.tail, p.map(_ :+ c))
  }
}