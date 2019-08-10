import scala.collection.mutable.PriorityQueue
class MedianFinder() {

    /** initialize your data structure here. */
    val lower = PriorityQueue[Int]()
    val upper = PriorityQueue[Int]()(Ordering.by(-_))
    var median = 0
    var odd = false

    def addNum(num: Int) {
        if (odd) {
            if (num > median) {
                upper += num
                lower += median
            } else {
                upper += median
                lower += num
            }
        } else {
            if (lower.isEmpty) {
                median = num
            } else if (num > upper.head) {
                upper += num
                median = upper.dequeue
            } else if (num < lower.head) {
                lower += num
                median = lower.dequeue
            } else {
                median = num
            }
        }
        odd = ! odd
    }

    def findMedian(): Double = {
        if (odd) median.toDouble
        else (lower.head.toDouble + upper.head.toDouble) / 2.0
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */