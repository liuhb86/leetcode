object Solution {
    def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
        val sum = nums.sum
        if (sum % k != 0) return false
        val target = sum / k
        if (nums.exists(_ > target)) return false
        dfs(nums.toList, Nil, target, k, target, true)
    }
    
    def dfs(nums: List[Int], next: List[Int], s: Int, k: Int, target: Int, first: Boolean) : Boolean = {
        if (k==1) return nums.sum == target
        if (nums == Nil) return false
        if (nums.head == s) {
            return dfs(next ++ nums.tail, Nil, target, k-1, target, true)
        }
        if (first) {
            return dfs(nums.tail, next, s-nums.head, k, target, false)
        }
        if (nums.head < s) {
            if (dfs(nums.tail, next, s-nums.head, k, target, false)) {
                return true
            }
        }
        dfs(nums.tail, nums.head :: next, s, k, target, false)
    }
}