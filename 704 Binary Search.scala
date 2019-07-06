object Solution {
    def search(nums: Array[Int], target: Int): Int = {
        var begin = 0
        var end = nums.length
        while (begin < end) {
            val mid = (begin + end) / 2
            if (nums(mid) == target) return mid
            if (nums(mid) < target) begin = mid+1
            else end = mid
        }
        -1
    }
}