
object Solution {
  def equationsPossible(equations: Array[String]): Boolean = {
    val uf = (0 until 26).toArray
    def find(i : Int) : Int = {
      //println(s"$i, ${uf(i)}")
      if (uf(i) != i) uf(i) = find(uf(i))
      uf(i)
    }
    for (e <- equations if e(1) == '=') {
      val a = find(e(0) -'a')
      val b = find(e(3) - 'a')
      val s = scala.math.min(a,b)
      uf(a) = s
      uf(b) = s
    }
    println(uf.mkString(","))
    for (e <- equations if e(1) == '!') {
      val a = e(0) -'a'
      val b = e(3) - 'a'
      if (find(a) == find(b)) return false
    }
    true
  }
}