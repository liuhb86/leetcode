object Solution {
    def triangleNumber(nums: Array[Int]): Int = {
        val s = nums.sorted
        var r = 0
        for (i<- 0 until nums.length - 2) {
            var k = i + 2
            val a = s(i)
            for (j <- i + 1 until nums.length - 1) {
                k = k.max(j+1)
                val b = s(j)
                val c = a + b
                while(k<nums.length && s(k) < c) k += 1
                r += (k - j - 1)
            }
        }
        r
    }
}