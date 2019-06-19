object Solution {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    if (k<=1) return 0
    var j = 0
    var p = 1
    var r = 0
    for (i<-nums.indices) {
      while(j < nums.length && (p * nums(j)) < k) {
        p *= nums(j)
        j += 1
      }
      r += j-i
      //println(s"$r $j")
      if (j > i) {
          p /= nums(i)
      } else {
          j = i + 1
      } 
    }
    r
  }
}