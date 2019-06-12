object Solution {
    def wiggleMaxLength(nums: Array[Int]): Int = {
        if (nums.length < 2) return nums.length
        wiggle(nums, true).max(wiggle(nums, false))
    }
    
    def wiggle(nums: Array[Int], _inc: Boolean) : Int = {
        var inc = _inc
        var last = nums.head
        var len = 1
        for (n <- nums) {
            if (n > last) {
                if (inc) {
                    inc = !inc; len +=1
                }
            } else if (n < last) {
                if (!inc) {
                    inc = !inc; len +=1
                }
            }
            last = n;
        }
        len
    }
}