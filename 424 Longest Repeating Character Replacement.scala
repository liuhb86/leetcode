object Solution {
    def characterReplacement(s: String, k: Int): Int = {
        if (s.isEmpty) return 0
        val f = Set(s:_*)
        f.toArray.map(solve(s,k,_)).max
    }
    
    def solve(s: String, k: Int, c: Char) : Int = {
        var i = 0
        var j = 0
        var x = 0
        while (j<s.length && s(j)==c) j+=1
        while (x<k && j < s.length) {
            j = move(j, s, c, true)
            x+=1
        }
        var m = j - i
        while (j < s.length) {
            i = move(i, s, c, false)
            j = move(j, s, c, true)
            m = scala.math.max(m, j - i)
        }
        m
    }
    
    def move(_i: Int, s: String, c: Char, moveAfter: Boolean) : Int = {
        var i = _i
        while (i<s.length && s(i) == c) i+=1
        if (i<s.length) i += 1
        if (moveAfter) {
            while (i<s.length && s(i) == c) i += 1
        }
        i
    }
}