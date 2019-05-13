object Solution {
    def subarraySum(nums: Array[Int], k: Int): Int = {
        val sumCount = scala.collection.mutable.Map[Int, Int]()
        sumCount += ((0->1))
        var sum = 0
        var total = 0
        for (n <- nums) {
            sum += n
            if (sumCount.contains(sum-k)) {
                total += sumCount(sum-k)
            }
            if (sumCount.contains(sum)) {
                sumCount(sum) += 1
            } else {
                sumCount += (sum ->1)
            }
        }
        total
    }
}