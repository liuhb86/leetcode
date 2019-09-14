object Solution {
    def beforeAndAfterPuzzles(phrases: Array[String]): List[String] = {
        val map = scala.collection.mutable.Map[String, List[(String,Int)]]()
        var list : List[(String, String, Int)] = Nil
        for (i<-phrases.indices) {
            val p = phrases(i)
            val s = p.split(" ")
            list = (p, s.last, i) :: list
            val t = if (s.length == 1) "" else " " + s.tail.mkString(" ")
            map(s.head) = (t, i):: map.getOrElse(s.head, Nil)
        }
        list.flatMap(x=> map.getOrElse(x._2,Nil).filter(_._2 !=x._3).map(x._1 + _._1))
            .distinct.sorted
    }
}