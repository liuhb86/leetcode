object Solution {
    def findErrorNums(nums: Array[Int]): Array[Int] = {
        var dup = 0
        for (i<-nums.indices) {
            var k = nums(i)
            nums(i) = 0
            while (k != 0) {
                if (nums(k-1) == k) {
                    dup = k
                    k = 0
                } else {
                    val t = nums(k-1)
                    nums(k-1) = k
                    k = t
                }
            }
        }
        for (i<-nums.indices) {
            if (nums(i) == 0) return Array(dup, i+1)
        }
        throw new Exception()
    }
}