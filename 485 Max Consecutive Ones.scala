object Solution {
    def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
        var m = 0
        var last = 0
        var c = 0
        for (n<-nums) {
            if (n == 0) {
                m = m.max(c)
                c = 0
            } else {
                c += 1
            }
            last = n
        }
        m.max(c)
    }
}