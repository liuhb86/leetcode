object Solution {
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    var pl : Long = 1
    while (pl <= n) pl <<= 1
    pl >>=1
    var p = pl.toInt
    var r = p
    while (p > 0 && (m&r) == (n&r)) {
      p >>=1
      r += p
    }
    m &(r-p)
  }
}