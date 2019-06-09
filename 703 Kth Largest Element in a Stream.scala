import scala.collection.mutable.PriorityQueue
class KthLargest(_k: Int, _nums: Array[Int]) {
    val pq = new PriorityQueue[Int]()(Ordering[Int].reverse)
    for (n <- _nums) {
        pq += n
        if (pq.length >_k) pq.dequeue
    }
    def add(`val`: Int): Int = {
        pq += `val`
        if (pq.length > _k) pq.dequeue
        pq.head
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = new KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */