object Solution {
    def smallestRange(nums: List[List[Int]]): Array[Int] = {
        val pq = new scala.collection.mutable.PriorityQueue[(Int, List[Int])]()(Ordering.by(-_._1))
        var m = nums.head.head
        for (h::t <- nums) {
            pq += ((h,t))
            m = m.max(h)
        }
        var r = Array(pq.head._1, m)
        var rm = r(1) - r(0)
        while (true) {
            val s = pq.dequeue
            val v = m - s._1
            if (v< rm) {
                rm = v
                r = Array(s._1, m)
            }
            if (s._2 == Nil) return r
            m = m.max(s._2.head)
            pq += ((s._2.head, s._2.tail))
        }
        throw new Exception()
    }
}