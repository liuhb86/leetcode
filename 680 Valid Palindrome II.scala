object Solution {
    def validPalindrome(s: String): Boolean = {
        check(s,0, s.length-1, true)
    }
    
    def check(s: String, _i: Int, _j: Int, removable: Boolean) : Boolean = {
        var i = _i
        var j = _j
        while (i< j) {
            if (s(i) == s(j)) {
                i += 1
                j -= 1
            } else {
                if (!removable) return false
                if (check(s, i+1, j, false)) return true
                return check(s, i, j-1, false)
            }
        }
        true
    }
}