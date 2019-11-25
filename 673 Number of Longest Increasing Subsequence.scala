// peek
object Solution {
    def findNumberOfLIS(nums: Array[Int]): Int = {
        val len = new Array[Int](nums.length)
        val count = new Array[Int](nums.length)
        var maxlen = 0
        var r = 0
        for (i<-nums.indices) {
            len(i) = 1
            count(i) = 1
            for (j<- 0 until i) {
                if (nums(i) > nums(j)) {
                    if (len(i) < len(j) + 1) {
                        len(i) =len(j) + 1
                        count(i) = count(j)
                    } else if (len(i) == len(j) + 1) {
                        count(i) += count(j)
                    }
                }
            }
            if (len(i) > maxlen) {
                maxlen = len(i)
                r = count(i)
            } else if (len(i) == maxlen) {
                r += count(i)
            }
        }
        r
    }
}