import scala.util.Random
class Solution(_nums: Array[Int]) {
    val n = Array(_nums:_*)
    /** Resets the array to its original configuration and return it. */
    def reset(): Array[Int] = {
        _nums
    }

    /** Returns a random shuffling of the array. */
    def shuffle(): Array[Int] = {
        for (i<-0 until n.length - 1) {
            val p = i + Random.nextInt(n.length - i)
            val t = n(i); n(i) = n(p); n(p) = t
        }
        n
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */