object Solution {
    def validTree(n: Int, edges: Array[Array[Int]]): Boolean = {
        if (edges.length != n - 1) return false
        val uf = (0 until n).toArray
        for (Array(a,b)<-edges) {
            val ra = r(uf, a)
            val rb = r(uf, b)
            if (ra==rb) return false
            uf(rb) = ra
        }
        true
    }
    
    def r(uf: Array[Int], i: Int) : Int = {
        if (uf(i)==i) return i
        uf(i) = r (uf, uf(i))
        return uf(i)
    }
}