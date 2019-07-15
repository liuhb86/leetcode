import scala.collection.mutable.Map
object Solution {
  def smallestSufficientTeam(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val skillMap = req_skills.zipWithIndex.toMap.mapValues( 1<< _)
    val p = people.map(x=>x.map(t=> skillMap.getOrElse(t, 0)).foldLeft(0)(_ | _))
      .map(~_).zipWithIndex.filter(~_._1 != 0)
    val cache = Map[(Int, Int), (Int, List[Int])]()
    //println(p.mkString(" "))
    solve(p, (1<< req_skills.length) -1, cache, 0)._2.toArray
  }

  def solve(p: List[(Int, Int)], s: Int, cache: Map[(Int, Int), (Int, List[Int])], i: Int) : (Int, List[Int]) = {
    //println(i, s)
    if (s==0) return (0, Nil)
    if (p == Nil) return (-1, Nil)
    val c = cache.get((i, s))
    if (c!= None) return c.get
    var m = -1
    var team : List[Int] = Nil
    val p1 = solve(p.tail, s & p.head._1, cache, i+1)
    if (p1._1 >=0) {
      m = p1._1 + 1
      team = p.head._2 :: p1._2
    }
    val p0 = solve(p.tail, s, cache, i+1)
    if (p0._1 >= 0) {
      if (m<0 || p0._1 < m) {
        m = p0._1; team = p0._2
      }
    }
    cache((i,s)) = (m, team)
    (m, team)
  }
}