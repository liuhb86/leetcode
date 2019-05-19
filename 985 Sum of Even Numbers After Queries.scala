object Solution {
    def sumEvenAfterQueries(A: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
        var sum = A.filter(_ %2 == 0).sum
        val r = new Array[Int](queries.length)
        for (i <- 0 until queries.length) {
            val Array(v, index) = queries(i)
            if (A(index) % 2== 0) sum -= A(index)
            A(index) += v
            if (A(index) % 2 == 0) sum += A(index)
            r(i) = sum
        }
        r
    }
}