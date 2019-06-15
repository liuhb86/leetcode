object Solution {
    def makesquare(nums: Array[Int]): Boolean = {
        val sum = nums.sum
        if (sum % 4 != 0) return false
        make(nums.toList, Nil, 1, sum/4, sum/4)
    }
    
    def make(nums: List[Int], next: List[Int], k: Int, s: Int, sum: Int) : Boolean= {
        if (nums.isEmpty) return false
        if (k==4) return nums.sum == sum
        if (nums.head < s) {
            if (make(nums.tail, next, k, s-nums.head, sum)) return true
        } else if (nums.head == s) {
            if (make(next ++ nums.tail, Nil, k+1, sum, sum)) return true
        }
        make(nums.tail, nums.head:: next, k,s, sum)
    }
}