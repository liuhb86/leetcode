object Solution {
    def treeDiameter(edges: Array[Array[Int]]): Int = {
        if (edges.isEmpty) return 0
        val g = Array.fill[List[Int]](edges.length + 1)(Nil)
        for (e<-edges) {
            g(e(0)) = e(1) :: g(e(0))
            g(e(1)) = e(0) :: g(e(1))
        }
        dfs(g, edges.head.head, 100000)._1 - 1
    }
    
    def dfs(g: Array[List[Int]], i: Int, p: Int) : (Int, Int) = {
        var cm1 = 0
        var cm2 = 0
        var m = 0
        val children = g(i)
        for (x <- children if x != p) {
            val (xm, xcm) = dfs(g, x, i)
            m = m.max(xm)
            if (xcm > cm1) {
                cm2 = cm1; cm1 = xcm
            } else if (xcm > cm2) {
                cm2 = xcm
            }
        }
        m = m.max(cm1+cm2+1)
        //println(i, m, cm1 + 1)
        (m, cm1 + 1)
    }
}