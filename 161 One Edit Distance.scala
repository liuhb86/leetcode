object Solution {
    def isOneEditDistance(s: String, t: String): Boolean = {
        val (a,b) = if (s.length <= t.length) (s,t) else (t,s)
        if (b.length - a.length > 1) return false
        var fixed = false
        var i = 0; var j = 0
        while (i<a.length) {
            if (a(i) != b(j)) {
                if (fixed) return false
                if (a.length == b.length) {
                    i+=1; j+=1
                } else {
                    j+=1
                }
                fixed = true
            } else {
                i += 1; j += 1
            }
        }
        fixed || a.length != b.length
    }
}