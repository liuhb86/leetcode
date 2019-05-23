object Solution {
    def findUnsortedSubarray(nums: Array[Int]): Int = {
        val sorted = nums.sortBy(identity).zip(nums)
        val i = sorted.indexWhere(t => t._1 != t._2)
        if (i < 0) return 0
        val j = sorted.lastIndexWhere(t => t._1 != t._2)
        j - i + 1
    }
}