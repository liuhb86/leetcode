object Solution {
    def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
        val map = scala.collection.mutable.Map[(Int, Int), Int]()
        var count = 0
        for(i<- 0 until points.length - 1) {
            for (j <- i + 1 until points.length) {
                val dx = points(i)(0) - points(j)(0)
                val dy = points(i)(1) - points(j)(1)
                val d = dx*dx + dy*dy
                val ci = map.getOrElse((i,d), 0)
                val cj = map.getOrElse((j, d), 0)
                count += (ci +cj)
                map((i,d)) = ci + 1
                map((j,d)) = cj + 1
            }
        }
        count * 2
    }
}