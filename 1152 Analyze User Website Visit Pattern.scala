object Solution {
    def mostVisitedPattern(username: Array[String], timestamp: Array[Int], website: Array[String]): List[String] = {
        val visit = username.zip(timestamp).zip(website).groupBy(_._1._1)
            .mapValues(_.toArray.sortBy(_._1._2))
        val seq = scala.collection.mutable.Map[(String, String, String), Int]()
        for ((_, v) <- visit) {
            val set = scala.collection.mutable.Set[(String, String, String)]()
            for (i<-0 to v.length - 3) {
                for (j<-i+1 to v.length - 2) {
                    for (k<-j+1 to v.length -1) {
                         val s = (v(i)._2, v(j)._2, v(k)._2)
                         if (!set(s)) {
                            set += s
                            seq(s) = seq.getOrElse(s, 0) + 1
                         }
                    }
                }
            }
        }
        //println(seq.mkString(" "))
        val r = seq.minBy(x=>(-x._2, x._1))._1
        List(r._1, r._2, r._3)
    }
}