object Solution {
    def maxRotateFunction(A: Array[Int]): Int = {
        val sum = A.sum
        var f = A.zipWithIndex.map(x=> x._1 * x._2).sum
        var m = f
        for (i<-0 until A.length -1) {
            //val f1 = f - (sum-A(i)) +(n-1)* A(i)
            val f1 = f - sum + A.length* A(i)
            m = m.max(f1)
            f = f1
        }
        m
    }
}