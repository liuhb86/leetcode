object Solution {
    def findRightInterval(intervals: Array[Array[Int]]): Array[Int] = {
        val s = intervals.zipWithIndex
            .flatMap(x => Array((x._1(0),1,x._2), (x._1(1),0,x._2))).sorted.reverse
        val r = new Array[Int](intervals.length)
        var lastStart = -1
        for ((v, t, i) <- s) {
            if (t==0) {
                r(i) = lastStart
            } else {
                lastStart = i
            }
        }
        r
    }
}