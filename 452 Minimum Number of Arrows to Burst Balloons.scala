object Solution {
    def findMinArrowShots(points: Array[Array[Int]]): Int = {
        val sorted = points.sortBy(_(1))
        var a = 0
        var s : Option[Int] = None
        for (Array(start, end)<-sorted) {
            if (s.isEmpty || start > s.get ) {
                a += 1
                s = Some(end)
            }
        }
        a
    }
}