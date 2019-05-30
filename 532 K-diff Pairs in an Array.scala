object Solution {
  def findPairs(nums: Array[Int], k: Int): Int = {
    if (k < 0) return 0
    if (k == 0) return nums.groupBy(identity).count(_._2.length > 1)
    val s = Set(nums:_*)
    s.count(x => s.contains(x+k))
  }
}