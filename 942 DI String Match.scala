object Solution {
    def diStringMatch(S: String): Array[Int] = {
        val n = S.length
        val r = new Array[Int](n+1)
        var i = 0
        var j = n
        for (k<- 0 until n) {
            if (S(k) == 'I') {
                r(k) = i
                i += 1
            } else {
                r(k) = j
                j-= 1
            }
        }
        r(n) = i
        r
    }
}