import scala.collection.mutable.Queue
class MovingAverage(_size: Int) {

    /** Initialize your data structure here. */
    var s = 0.0
    val q = Queue[Double]()

    def next(`val`: Int): Double = {
        if (_size <= 0) return 0.0
        val d = `val`.toDouble
        if (q.size == _size) s -= q.dequeue
        q += d
        s += d
        s / q.size
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = new MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */