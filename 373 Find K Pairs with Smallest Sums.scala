import scala.collection.mutable.{PriorityQueue, ListBuffer}
object Solution {
    def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[Array[Int]] = {
        if (nums1.isEmpty || nums2.isEmpty) return Nil
        val result = new ListBuffer[Array[Int]]()
        val pq = new PriorityQueue[(Int, Int, Int)]()(Ordering.by(-_._1))
        pq ++= (0 until nums1.length).map(i=> (nums1(i)+ nums2.head, i, 0))
        for (t <- 1 to scala.math.min(k, nums1.length * nums2.length)) {
            val (s, i, j0) = pq.dequeue
            result += Array(nums1(i), nums2(j0))
            val j = j0 + 1
            if (j < nums2.length) pq += ((nums1(i) + nums2(j), i, j))
        }
        result.toList
    }
}