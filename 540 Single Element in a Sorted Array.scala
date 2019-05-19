object Solution {
    def singleNonDuplicate(nums: Array[Int]): Int = {
        var lb = 0
        var ub = nums.length / 2
        while (ub > lb) {
            val mid = (lb + ub) / 2
            val index = mid * 2
            if (nums(index) != nums(index + 1)) {
                ub = mid
            } else {
                lb = mid + 1
            }
        }
        nums(2* lb)
    }
}