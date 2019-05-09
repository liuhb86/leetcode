object Solution {
    def largestPerimeter(A: Array[Int]): Int = {
        val sorted = A.sorted.reverse
        for (i <- 0 to sorted.length -3 ) {
            if (sorted(i) < sorted(i + 1) + sorted(i + 2)) {
                return sorted(i) + sorted(i + 1) + sorted(i+2)
            }
        }
        0
    }
}