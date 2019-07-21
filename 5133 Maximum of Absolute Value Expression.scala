import scala.math.abs
object Solution {
    def maxAbsValExpr(arr1: Array[Int], arr2: Array[Int]): Int = {
        var r = 0
        for (i<- arr1.indices) {
            for (j<- i+1 until arr2.length) {
                val v = abs(arr1(i)-arr1(j)) + abs(arr2(i)-arr2(j)) + j - i
                r = r.max(v)
            }
        }
        r
    }
}