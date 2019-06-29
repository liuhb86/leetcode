object Solution {
    def rob(nums: Array[Int]): Int = {
        var m = 0
        var mnr = 0
        for (n<-nums) {
            val mr = mnr + n
            mnr = m
            m = m.max(mr)
        }
        m
    }
}