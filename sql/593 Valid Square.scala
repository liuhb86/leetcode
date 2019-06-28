object Solution {
    def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
        val p = Array(p1,p2,p3,p4)
        val d = for(i<-p.indices; j<- i + 1 until p.length) yield {
            val pp1 = p(i); val pp2= p(j)
            val dx = (pp1(0) - pp2(0)).toLong
            val dy = (pp1(1) -pp2(1)).toLong
            dx*dx + dy* dy
        }
        val s = d.sorted
        val s0 = s(0)
        s0 > 0 && s0 == s(1) && s0==s(2) && s0==s(3)
    }
}