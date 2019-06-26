object Solution {
    def firstUniqChar(s: String): Int = {
        val c = s.groupBy(identity).filter(_._2.length ==1).keySet
        s.indexWhere(x=>c.contains(x))
    }
}