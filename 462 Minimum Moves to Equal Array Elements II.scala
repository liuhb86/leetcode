object Solution {
    def minMoves2(nums: Array[Int]): Int = {
        if (nums.isEmpty) return 0
        val sorted = nums.sorted
        val median = sorted(nums.length/2)
        nums.map(x => scala.math.abs(x - median)).sum
    }
}