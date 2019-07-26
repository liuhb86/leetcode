object Solution {
    def smallestRangeII(A: Array[Int], K: Int): Int = {
        if (A.length == 1) return 0
        val mx = A.max
        val mn = A.min
        // mn - mx + 2*K >=mx-mn
        if (mn - mx + K >= 0) return mx - mn
        var r = mx - mn
        val s = A.sorted
        for (i<- 1 until s.length) {
            if (s(i)-K >= s(i-1) + K) return mx - K - mn - K
            r = r.min((s(i-1) + K).max(s.last - K) - (s(i) - K).min(s.head + K))
        }
        r
    }
}