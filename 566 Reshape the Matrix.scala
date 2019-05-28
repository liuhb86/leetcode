object Solution {
  def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
    if (nums.isEmpty) return nums
    if (nums.length * nums.head.length != r * c) return nums
    val it = new It(nums)
    val result = new Array[Array[Int]](r)
    for (i <- 0 until r) {
      result(i) = new Array[Int](c)
      for (j <- 0 until c) {
        result(i)(j) = it.next()
      }
    }
    result
  }
}

class It(nums: Array[Array[Int]]) {
  var r = 0
  var c = 0
  def next() : Int = {
    val result = nums(r)(c)
    c += 1
    if (c == nums(r).length) {
      r += 1
      c = 0
    }
    result
  }
}