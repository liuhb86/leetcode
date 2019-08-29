object Solution {
    def canAttendMeetings(intervals: Array[Array[Int]]): Boolean = {
        if (intervals.isEmpty) return true
        val sorted = intervals.sortBy(_(0))
        var s = sorted.head.apply(0)
        for (i<-sorted) {
            if (i(0)< s) return false
            s = i(1)
        }
        true
    }
}