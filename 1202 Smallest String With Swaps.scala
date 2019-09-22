object Solution {
    def smallestStringWithSwaps(s: String, pairs: List[List[Int]]): String = {
        val p = (0 until s.length).toArray
        for (a::b::Nil <-pairs) {
            val ra = uf(p, a)
            val rb = uf(p,b)
            if (ra != rb) {
                p(rb) = ra
            }
        }
        val sa = s.toArray
        val gs = (0 until s.length).groupBy(x=> uf(p,x))
        for (g<-gs.values) {
            val sg = g.sorted
            val rs = sg.map(s(_)).sorted
            for (i<-sg.indices) {
                sa(sg(i)) = rs(i)
            }
        }
        sa.mkString
    }
    
    def uf(p: Array[Int], i: Int): Int = {
        if (p(i) == i) return i
        p(i) = uf(p, p(i))
        p(i)
    }
}