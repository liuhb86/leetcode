object Solution {
  def findIntegers(num: Int): Int = {
    var k = 1
    var x = num
    while (x > 1) {x >>=1; k+=1}
    val dp = new Array[Int]((k+1).max(3))
    dp(1) = 2; dp(2) = 3
    for (i<- 3 to k) dp(i) = dp(i-1) + dp(i-2)
    //println(k)
    //println(dp.mkString(","))
    find(num, dp)
  }

  def find(n: Int, dp: Array[Int]) : Int = {
    if (n<3) return n+1
    if (n==3) return n
    var k = 1
    var x = n
    while (x > 1) {x >>=1; k+=1}
    val r = if ((n & (1<<(k-2))) == 0) find(n-(1<<(k-1)), dp)
    else dp(k-2)
    val rr = r + dp(k-1)
    //println(s"$n $rr")
    rr
  }
}