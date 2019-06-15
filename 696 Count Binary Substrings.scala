object Solution {
    def countBinarySubstrings(s: String): Int = {
        var t = 0
        var c = 0
        var p = 0
        var i = 0
        while (i < s.length) {
            c+=1
            if (i == s.length -1 || s(i)!=s(i+1)) {
                t += c.min(p)
                p = c
                c = 0
            }
            i+=1
        }
        t
    }
}