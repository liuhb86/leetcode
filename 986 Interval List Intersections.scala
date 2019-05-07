import scala.math.{min,max}
import scala.collection.mutable.ArrayBuffer
object Solution {
    def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
        val itA = A.toIterator.buffered
        val itB = B.toIterator.buffered
        val result = new ArrayBuffer[Array[Int]]
        while (itA.hasNext && itB.hasNext) {
            val a = itA.head
            val b = itB.head
            if (a(1) < b(0) || b(1) < a(0)) {
                // no overlap
            } else if (a(0) <= b(0) && a(1) >= b(1)) {
                // a contains b
                result += b
            } else if (b(0) <= a(0) && b(1) >= a(1)) {
                // b contains a
                result += a
            } else {
                // partially overlap
                result += Array(max(a(0),b(0)), min(a(1), b(1)))
            }
            if (a(1) < b(1)) itA.next() else itB.next()
        }
        result.toArray
    }
}