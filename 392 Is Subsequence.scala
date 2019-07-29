object Solution {
    def isSubsequence(s: String, t: String): Boolean = {
        var i = 0
        var j = 0
        while (i<s.length && j < t.length) {
            if (s(i) == t(j)) i+=1
            j+=1
        }
        i == s.length
    }
}