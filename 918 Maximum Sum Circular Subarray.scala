import scala.math.{max,min}
object Solution {
    def maxSubarraySumCircular(A: Array[Int]): Int = {
        if (A.forall(_ <0)) return A.max
        var mx = 0
        var mn = 0
        var a = A.head
        var b = A.head
        var sum = 0
        for (n <- A) {
            sum += n
            a = min(sum - mx, a)
            b = max(sum - mn, b)
            mx = max(mx, sum)
            mn = min(mn, sum)
        }
        max(sum - a, b)
    }
}