class RecentCounter() {
    val q = scala.collection.mutable.Queue[Int]()
    def ping(t: Int): Int = {
        q += t
        val o = t-3000
        while (q.head < o) q.dequeue
        q.length
    }

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = new RecentCounter()
 * var param_1 = obj.ping(t)
 */