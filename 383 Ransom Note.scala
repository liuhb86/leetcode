object Solution {
    def canConstruct(ransomNote: String, magazine: String): Boolean = {
        val s1 = ransomNote.groupBy(identity).mapValues(_.length)
        val s2 = magazine.groupBy(identity).mapValues(_.length)
        s1.forall{case (k,v) =>
            s2.contains(k) && s2(k) >= v
        }
    }
}