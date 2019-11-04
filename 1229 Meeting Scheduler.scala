object Solution {
    def minAvailableDuration(slots1: Array[Array[Int]], slots2: Array[Array[Int]], duration: Int): List[Int] = {
        val s1 = slots1.sortBy(_(0))
        val s2 = slots2.sortBy(_(0))
        var i = 0
        var j = 0
        while (i<s1.length && j<s2.length) {
            val Array(b1, e1) = s1(i)
            val Array(b2, e2) = s2(j)
            val b = b1.max(b2)
            val e = e1.min(e2)
            //println(i,j, b,e)
            if (e-b>=duration) return List(b, b+duration)
            if (e1 < e2) i += 1 else j+=1
        }
        Nil
    }
}