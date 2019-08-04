object Solution {
    def minEatingSpeed(piles: Array[Int], H: Int): Int = {
        val pl = piles.map(_.toLong)
        var begin = 1L
        var end = pl.max + 1
        while (end - begin > 1) {
            val mid = (begin + end - 1) / 2
            val t = time(pl, mid)
            //println(mid, t)
            if (t<=H) {
                end = mid + 1
            } else {
                begin = mid + 1
            }
        }
        begin.toInt
    }
    
    def time(piles: Array[Long], speed: Long) : Long = {
        piles.map(x=> (x + speed - 1) / speed).sum
    }
}