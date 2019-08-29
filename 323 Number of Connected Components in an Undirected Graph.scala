object Solution {
    def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
        var res = n
        val uf = (0 to n-1).toArray
        for (Array(a,b)<-edges) {
            val ra = r(uf, a)
            val rb = r(uf, b)
            if (ra != rb) {
                res -= 1
                uf(rb) = ra
            }
        }
        res
    }
    
    def r(uf: Array[Int], i : Int) : Int = {
        if (uf(i) ==i) return i
        val v = r(uf, uf(i))
        uf(i) = v
        v
    }
}