object Solution {
    def findKthLargest(nums: Array[Int], k: Int): Int = {
        val pq = scala.collection.mutable.PriorityQueue[Int]()(Ordering.by(-_))
        for (n<- nums) {
            pq += n
            if (pq.size > k) pq.dequeue
        }
        pq.dequeue
    }
}