import scala.collection.mutable.PriorityQueue
object Solution {
    def maximumProduct(nums: Array[Int]): Int = {
        val mins = new PriorityQueue[Int]()
        val maxs = new PriorityQueue[Int]()(Ordering.by(-_))
        maxs ++= nums.take(3)
        mins ++= nums.take(3)
        mins.dequeue
        for (n <- nums.drop(3)) {
            maxs += n
            maxs.dequeue
            mins += n
            mins.dequeue
        }
        val max3 = maxs.dequeue
        val max2 = maxs.dequeue
        val max1 = maxs.dequeue
        val min2 = mins.dequeue
        val min1 = mins.dequeue
        scala.math.max(max3*max2*max1, max1*min1*min2)
    }
}