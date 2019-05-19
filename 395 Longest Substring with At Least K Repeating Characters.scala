object Solution {
    def longestSubstring(s: String, k: Int): Int = {
        if (s.length < k) return 0
        val invalidChars = s.groupBy(identity)
        .toArray.filter(_._2.length < k).map(_._1).mkString
        //println(invalidChars)
        if (invalidChars.isEmpty) return s.length
        val splits = s.split(s"[$invalidChars]").distinct.sortBy(-_.length)
        var max = 0
        for (x <- splits) {
            if (x.length < max) return max
            val r = longestSubstring(x, k)
            if (r > max) max = r
        }
        max
    }
}