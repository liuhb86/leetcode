object Solution {
    def minCost(costs: Array[Array[Int]]): Int = {
        var c1 = new Array[Int](3)
        var c2 = new Array[Int](3)
        for (c<-costs) {
            for (i<-0 until 3) {
                var s = Int.MaxValue
                for (j<-0 until 3 if j != i) {
                    s = s.min(c1(j))
                }
                c2(i) = s + c(i)
            }
            val t = c1; c1 = c2; c2 = t
        }
        c1.min
    }
}