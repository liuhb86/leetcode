object Solution {
    def smallestRangeI(A: Array[Int], K: Int): Int = {
        val max = A.max
        val min = A.min
        scala.math.max(max - min - 2*K, 0)
    }
}