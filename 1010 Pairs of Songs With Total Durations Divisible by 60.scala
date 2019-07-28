object Solution {
    def numPairsDivisibleBy60(time: Array[Int]): Int = {
        var r = 0
        val map = scala.collection.mutable.Map[Int, Int]()
        for (t<- time) {
            val m = t % 60
            val c = if (m==0) 0 else 60 - m
            r += map.getOrElse(c, 0)
            map(m) = map.getOrElse(m, 0) + 1
        }
        r
    }
}