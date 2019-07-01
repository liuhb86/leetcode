object Solution {
    def reverseStr(s: String, k: Int): String = {
        val a = s.toArray
        var i = 0
        while (i<s.length) {
            var x = i
            var y = (s.length -1).min(i + k - 1)
            while (x<y) {
                val t = a(x); a(x) = a(y); a(y)= t
                x +=1; y-=1
            }
            i += k + k
        }
        a.mkString
    }
}