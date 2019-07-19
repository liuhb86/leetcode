object Solution {
    def decodeAtIndex(S: String, K: Int): String = {
        var L = 0L
        var i = 0
        while(L<K) {
            if (S(i).isDigit) {
                L *= (S(i) - '0')
            } else {
                L += 1
            }
            i+=1
        }
        var k : Long = K - 1
        for (j<- i-1 to 0 by -1) {
            if (S(j).isDigit) {
                L = L / (S(j)-'0')
                k = k % L
            } else {
                if (L == k + 1) return S(j).toString
                L -= 1
            }
        }
        throw new Exception()
    }
}