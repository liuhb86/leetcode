object Solution {
  def findMaxLength(nums: Array[Int]): Int = {
    var ml = 0
    val n = nums.length
    var s = n
    val t = Array.fill(n*2+1)(-2)
    t(n) = -1
    for (i<- 0 until nums.length) {
      s += (if (nums(i)==0) -1 else 1)
      //println(s)
      //println(t.mkString(","))
      if (t(s) < -1) {
        t(s) = i
      } else {
        ml = scala.math.max(ml, i - t(s))
      }
    }
    ml
  }
}