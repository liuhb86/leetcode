object Solution {
    def findLengthOfLCIS(nums: Array[Int]): Int = {
        var ml = 0
        var i = 0 
        while (i<nums.length) {
            var j = i + 1
            while (j<nums.length && nums(j) > nums(j-1)) j += 1
            ml = ml.max(j-i)
            i = j
        }
        ml
    }
}