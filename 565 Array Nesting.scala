object Solution {
    def arrayNesting(nums: Array[Int]): Int = {
        var r = 0
        for (i<-nums.indices) {
            var k = 0
            var j = i
            while (nums(j) != -1) {
                val t = nums(j)
                nums(j) = -1
                k += 1
                j = t
            }
            r = r.max(k)
        }
        r
    }
}