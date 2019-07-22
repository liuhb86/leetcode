object Solution {
    def customSortString(S: String, T: String): String = {
        val map = S.zipWithIndex.toMap
        T.map(c => (c, map.getOrElse(c,-1))).sortBy(_._2).map(_._1).mkString
    }
}