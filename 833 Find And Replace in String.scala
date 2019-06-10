object Solution {
    def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
        val r = new scala.collection.mutable.StringBuilder()
        val x = indexes.zip(sources.zip(targets)).sortBy(_._1)
        var last = 0
        for ((i,(s, t)) <- x) {
            if (S.substring(i, i+s.length) == s) {
                r ++= S.substring(last, i)
                r ++= t
                last = i + s.length
            }            
        }
        r ++= S.substring(last, S.length)
        r.toString
    }
}