object Solution {
    def largestUniqueNumber(A: Array[Int]): Int = {
        val g = A.groupBy(identity).filter(_._2.length == 1)
        if (g.isEmpty) -1 else g.keys.max
    }
}