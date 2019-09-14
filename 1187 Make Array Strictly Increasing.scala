// peek
object Solution {
  def makeArrayIncreasing(arr1: Array[Int], arr2: Array[Int]): Int = {
    val M = 3000
    val map = (arr1 ++ arr2).distinct.sorted

    val set = arr2.toSet

    val dp = Array.ofDim[Int](arr1.length, map.length)
    for (i<- arr1.indices) {
      for (j<-map.indices) {
        var v = M
        if (i==0) {
          if (map(j) == arr1(i)) v = 0
          else if (set(map(j)))  v = 1
        } else {
          if (arr1(i)== map(j) && j > 0) v = dp(i-1)(j-1)
          else if (set(map(j)) && j > 0) v = dp(i-1)(j-1) + 1
        }
        if (j> 0) v = v.min(dp(i)(j-1))

        dp(i)(j) = v
        //println(i, j, map(j),  dp(i)(j))
      }
    }

    if (dp(arr1.length -1)(map.length-1) < M) dp(arr1.length -1)(map.length-1) else -1
  }
}