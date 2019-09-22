object Solution {
    def minimumCost(N: Int, connections: Array[Array[Int]]): Int = {
        val s = connections.sortBy(_(2))
        val p = (0 to N).toArray
        var r = 0
        var count = 0
        for (Array(a,b,c)<-s) {
            val ra = uf(p,a)
            val rb = uf(p,b)
            if (ra != rb) {
                r += c
                count +=1
                p(rb) = ra
            }
        }
        if (count == N-1) r else -1
    }
    
    def uf(p: Array[Int], i: Int) : Int = {
        if (p(i) == i) return i
        p(i) = uf(p, p(i))
        p(i)
    }
}