object Solution {
    def pivotIndex(nums: Array[Int]): Int = {
        var right = nums.sum
        var left = 0
        for (i<- 0 until nums.length) {
            right -= nums(i)
            if (left == right) return i
            left+= nums(i)
        }
        return -1
    }
}