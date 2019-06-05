import scala.math.{max, min}
object Solution {
    def partitionDisjoint(A: Array[Int]): Int = {
        val mn = new Array[Int](A.length)
        mn(A.length - 1) = A.last
        for (i <- A.length -2 to 0 by -1) {
            mn(i) = min(A(i), mn(i+1))
        }
        var mx = A.head
        for (i<-0 until A.length - 1) {
            mx = max(mx, A(i))
            if (mx <= mn(i+1)) {
                return i+1
            }
        }
        throw new Exception()
    }
}