object Solution {
    def nextClosestTime(time: String): String = {
        val d = time.replace(":","").toSet.toArray.map(_.toString)
        val t0 = time.substring(0,2).toInt * 60 + time.substring(3,5).toInt + 1
        val h = (for (i<-d; j<-d) yield i + j).filter (_ < "24")
        val m = (for (i<-d; j<-d) yield i + j).filter (_ < "60")
        val t = for (i<-h; j<-m) yield (i, j, (i.toInt * 60 + j.toInt + 48*60 - t0) % (24 * 60))
        val r = t.minBy(_._3)
        s"${r._1}:${r._2}"
    }
}