import scala.math.max
object Solution {
    def maxProfitAssignment(difficulty: Array[Int], profit: Array[Int], worker: Array[Int]): Int = {
        val sorted = difficulty.zip(profit).sortBy(_._1)
        var maxp = 0
        val adjusted = sorted.map(x => {maxp = max(maxp, x._2); (x._1, maxp)})
        worker.map(search(adjusted, _)).sum
    }
    
    def search(profit: Array[(Int, Int)], v: Int) : Int = {
        var begin = 0
        var end = profit.length
        while (end-begin > 1) {
            val mid = (begin + end -1)/ 2
            if (profit(mid)._1>v) {
                end = mid + 1
            } else {
                begin = mid + 1
            }
        }
        if (begin < end && profit(begin)._1<=v) begin += 1
        if (begin ==0) return 0
        profit(begin-1)._2
    }
}