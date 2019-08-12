object Solution {
    def isMajorityElement(nums: Array[Int], target: Int): Boolean = {
        var begin = 0
        var end = nums.length
        while (end -begin > 1) {
            val mid = (begin + end -1)/2
            val v = nums(mid)
            if (v<target) {
                begin = mid+1
            } else if (v > target) {
                end = mid
            } else {
                end = mid + 1
            }
        }
        if (begin == end) return false
        if (nums(begin)!= target) return false
        end = begin + nums.length / 2
        end < nums.length && nums(end) == target
    }
}