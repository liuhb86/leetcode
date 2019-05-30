object Solution {
    def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
        val d = (A.sum - B.sum) / 2
        val s = Set(B:_*)
        for (n <- A) {
            if (s.contains(n - d)) return Array(n, n-d)
        }
        throw new Exception()
    }
}