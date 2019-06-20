object Solution {
    def smallestRepunitDivByK(K: Int): Int = {
        if (K % 2 == 0) return -1
        var n = 1 % K
        var l = 1
        val visited = new Array[Boolean](K)
        while(true) {
            if (visited(n)) return -1
            if (n% K == 0) return l
            visited(n) = true
            n = (n*10 + 1) % K
            l+=1
        }
        throw new Exception()
    }
}