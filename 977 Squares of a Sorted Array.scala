import scala.collection.mutable.ArrayBuffer

object Solution {
    def sortedSquares(A: Array[Int]): Array[Int] = {
        val result = new ArrayBuffer[Int]
        var i = 0
        var j = A.length -1
        while(i <= j) {
            val ai = A(i)
            val aj = A(j)
            val ai2 = ai * ai
            val aj2 = aj * aj
            if (ai2 < aj2) {
                result += aj2
                j -= 1
            } else {
                result += ai2
                i += 1
            }
        }
        result.reverse.toArray
    }
}