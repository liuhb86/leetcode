object Solution {
  def totalHammingDistance(nums: Array[Int]): Int = {
    val c = new Array[Int](30)
    var count = 0
    for (i <- 0 until nums.length) {
      var k = 0
      var n = nums(i)
      for (k<- 0 until 30) {
        val b = n & 1
        count += (if (b==0) {
          c(k)
        } else {
          i - c(k)
        })
        if (b==1) c(k) += 1
        n >>= 1
      }
    }
    count
  }
}