object Solution {
  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
    val houses_s = houses.sorted
    val heaters_s = heaters.sorted
    var prev = 0
    var next = 0
    var r = 0
    for (h <- houses_s) {
      var m = -1
      while(prev + 1 < heaters_s.length && heaters_s(prev+1) <= h) {
        prev += 1
      }
      if (heaters_s(prev) <= h) m = h - heaters_s(prev)
      while(next + 1 < heaters_s.length && heaters_s(next)<=h) {
        next += 1
      }
      if (heaters_s(next) > h) {
        val n = heaters_s(next) - h
        if (m < 0 || n < m) {
          m = n
        }
      }
      if (m > r) r = m
      //println(s"$prev, $next, $m")
    }
    r
  }
}