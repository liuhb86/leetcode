object Solution {
    def kthGrammar(N: Int, K: Int): Int = {
        var r = 0
        var k = K - 1
        while(k>0) {
            r ^= (k & 1)
            k >>= 1
        }
        r
    }
}