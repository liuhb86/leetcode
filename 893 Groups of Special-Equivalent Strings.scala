object Solution {
    def numSpecialEquivGroups(A: Array[String]): Int = {
        A.map(toPair).toSet.size
    }
    
    def toPair(s: String) : (String, String) = {
        val p = s.zipWithIndex.partition(_._2%2==0)
        (p._1.map(_._1).sorted.mkString, p._2.map(_._1).sorted.mkString)
    }
    
}