object Solution {
    def combinationSum4(nums: Array[Int], target: Int): Int = {
        val dp = new Array[Int](target + 1)
        dp(0) = 1
        for (i<- 1 to target) {
            for (n <- nums if n <= i) {
                dp(i) += dp(i-n)
            }
        }
        dp(target)
    }
}