object Solution {
    def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
        val map = scala.collection.mutable.Map[Int, Int]()
        for (c<-C;d<-D) {
            val s = c+d
            map(s) = map.getOrElse(s,0) + 1
        }
        var r = 0
        for (a<-A;b<-B) {
            r += map.getOrElse(-(a+b), 0)
        }
        r
    }
}