object Solution {
    def countSubstrings(s: String): Int = {
        var count = 0
        for (k<- 0 until s.length) {
            count += 1
            var i = k - 1
            var j = k + 1
            while (i >= 0 && j < s.length && s(i) == s(j)) {
                count += 1
                i -= 1
                j += 1
            }
            i = k
            j = k + 1
            while (i >= 0 && j < s.length && s(i) == s(j)) {
                count += 1
                i -= 1
                j += 1
            }
        }
        count
    }
}