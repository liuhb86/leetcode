object Solution {
    def find132pattern(nums: Array[Int]): Boolean = {
        if (nums.isEmpty) return false
        val n = nums.length
        val minLeft = new Array[Int](n)
        minLeft(0) = nums(0)
        for (i <- 1 until n) minLeft(i) = List(nums(i), minLeft(i - 1)).min
        for (j <- 1 until n - 1) {
            val ai = minLeft(j - 1)
            val aj = nums(j)
            if (ai < aj) {
                for (k <- j + 1 until n) {
                    val ak = nums(k)
                    if (ak > ai && ak < aj) return true
                }
            }
        }
        false
    }
}