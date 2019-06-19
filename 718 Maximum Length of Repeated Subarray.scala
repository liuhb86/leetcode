object Solution {
    def findLength(A: Array[Int], B: Array[Int]): Int = {
        val p = new Array[Int](A.length)
        var m = 0
        for (d<-B) {
            for (i<-A.length -1 to 0 by -1) {
                if (A(i)==d) {
                    p(i) = if (i==0) 1 else p(i-1) +1
                    m = m.max(p(i))
                } else {
                    p(i) = 0
                }
            }
        }
        m
    }
}