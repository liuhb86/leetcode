object Solution {
    def bestRotation(A: Array[Int]): Int = {
        val n = A.length
        val decrease = new Array[Int](A.length)
        for (i<-1 until n) {
            val v = A(i)
            if (v<=i && v>0) decrease(i-v+1) +=1
        }
        var s = 0
        for (i<-1 until n) {
            s += decrease(i)
            decrease(i) = s
            val v = A(i)
            if (v<=i && v>0) s-=1
        }
        val increase = new Array[Int](A.length)
        for (i<-0 until n-1) {
            val v = A(i)
            if (v>i && v<n) increase(v-i) +=1
        }
        s = 0
        for (i<- 1 until n) {
            s += increase(i)
            increase(i) = s
            val j = n-i-1
            val v = A(j)
            if (v>j && v<n) s-=1
        }
        //println(increase.mkString(","))
        //println(decrease.mkString(","))
        var maxd = 0
        var maxk = 0
        for (k<-1 until n) {
            val d = increase(n-k) - decrease(k)
            //println(d)
            if (d > maxd) {
                maxd = d
                maxk = k
            }
        }
        maxk
    }
}