object Solution {
    def frequencySort(s: String): String = {
        val f = s.groupBy(identity).mapValues(_.length)
        f.toArray.sortBy(-_._2).map(x=> x._1.toString * x._2).mkString
    }
}