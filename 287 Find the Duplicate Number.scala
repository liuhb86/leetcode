object Solution {
    def findDuplicate(nums: Array[Int]): Int = {
        var start = 1
        var end = nums.length
        while (start  < end) {
            val mid = start + (end - start) / 2
            //println(mid)
            var eq = 0
            var le = 0
            for (x<- nums) {
                if (x==mid) eq += 1
                else if (x<mid) le += 1
            }
            //println(eq, le)
            if (eq > 1) return mid
            if (le + eq > mid) {
                end = mid
            } else {
                start = mid + 1
            }
            //println(start, end)
        }
        throw new Exception()
    }
}