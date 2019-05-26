object Solution {
    def maxSatisfied(customers: Array[Int], grumpy: Array[Int], X: Int): Int = {
        if (X >= customers.length) return customers.sum
        var sum = customers.zip(grumpy).map(x=> if (x._2==0) x._1 else 0).sum
        //println(sum)
        if (X<=0) return sum
        var m = 0
        for (i<- 0 until X) {
            if (grumpy(i)==1) m += customers(i)
        }
        //println(m)
        var e = m
        for (i <- X until customers.length) {
            val j = i - X
            if (grumpy(j) == 1) e -= customers(j)
            if (grumpy(i)==1) e+= customers(i)
            //println(e)
            if (e > m) m = e
        }
        sum + m
    }
}