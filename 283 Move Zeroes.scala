object Solution {
    def moveZeroes(nums: Array[Int]): Unit = {
        var j = 0
        for (i<-nums.indices) {
            j = nums.indexWhere(_!=0, j)
            if (j < 0) {
                for (k<-i until nums.length) nums(k) = 0
                return
            }
            nums(i) = nums(j)
            j += 1
        }
    }
}