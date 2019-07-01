object Solution {
    def findMaxAverage(nums: Array[Int], k: Int): Double = {
        var avg = nums.take(k).sum.toDouble / k
        var m = avg
        for (i<-k until nums.length) {
            avg = avg + (nums(i) - nums(i-k)).toDouble / k
            m = m.max(avg)
        }
        m
    }
}