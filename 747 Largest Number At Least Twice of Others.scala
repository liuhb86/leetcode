object Solution {
    def dominantIndex(nums: Array[Int]): Int = {
        if (nums.length < 2) return 0
        var m1 = Int.MinValue
        var m2 = Int.MinValue
        var mi = 0
        for (i<-nums.indices) {
            val n = nums(i)
            if (n>m1) {
                m2=m1;m1=n; mi = i 
            } else if (n > m2) {
                m2 = n
            }
        }
        if (m1 >= 2* m2) mi else -1
    }
}