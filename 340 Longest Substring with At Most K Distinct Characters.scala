object Solution {
    def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
        if (k == 0) return 0
        var r = 0
        val map = scala.collection.mutable.Map[Char, Int]()
        var j = 0
        for (i<-s.indices) {
            while(j < s.length && (map.size < k || map.contains(s(j)))) {
                map(s(j)) = map.getOrElse(s(j), 0) + 1
                j+=1
            }
            r = r.max(j-i)
            if (map(s(i)) == 1) map -= s(i)
            else map(s(i)) -= 1
        }
        r
    }
}