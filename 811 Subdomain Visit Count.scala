object Solution {
    def subdomainVisits(cpdomains: Array[String]): List[String] = {
        val map = scala.collection.mutable.Map[String, Int]()
        for (pair<-cpdomains) {
            val Array(cs, domain) = pair.split(" ", 2)
            val count = cs.toInt
            map(domain) = map.getOrElse(domain, 0) + count
            val splits = domain.split("\\.")
            //println(splits.mkString("/"))
            for (i <- 1 until splits.length) {
                val subdomain = splits.drop(i).mkString(".")
                map(subdomain) = map.getOrElse(subdomain, 0) + count
            }
        }
        map.map(d=>s"${d._2} ${d._1}").toList
    }
}