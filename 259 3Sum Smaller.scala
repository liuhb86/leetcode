object Solution {
    def threeSumSmaller(nums: Array[Int], target: Int): Int = {
        var r = 0
        val s = nums.sorted
        for (i<- 0 to s.length -3) {
            var j = i + 1
            var k = s.length - 1
            while (j<k) {
                while (k >j && s(i) + s(j) + s(k) >= target) k-=1
                r += k-j
                j += 1
            }
        }
        r
    }
}