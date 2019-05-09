import scala.collection.mutable.Queue
object Solution {
    def new21Game(N: Int, K: Int, W: Int): Double = {
        if (K == 0) return if (N >=0) 1 else 0
        if (N >= K + W - 1) return 1
        val queue = new Queue[Double]
        var lastW = 1.0
        queue += lastW
        var prob = 0.0
        for (i <- 1 to N) {
            val p = lastW / W
            if (i >= K) {
                prob += p
            } else {
                lastW += p
                queue += p
            }
            if (i >= W) lastW -= queue.dequeue()
            // println(s"$i, $p")
        }
        prob
    }
}