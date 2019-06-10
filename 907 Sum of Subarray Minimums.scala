import scala.collection.mutable.ArrayBuffer
object Solution {
    val M= 1000000007
    def sumSubarrayMins(A: Array[Int]): Int = {
        val s = new ArrayBuffer[(Int, Int)]()
        var sum = 0
        for (i<- 0 to A.length) {
            val v = if (i<A.length) A(i) else 0
            while (s.nonEmpty && (i==A.length ||v < s.last._1)) {
                val (n, j) = s.last
                s.trimEnd(1)
                val k = if (s.isEmpty) -1 else s.last._2
                var c = (((n * (j-k)) % M) * (i-j)) % M
                sum = (sum + c) % M
                //println(s"$n,$j,$i,$k,$c,$sum")
            }
            s += ((v, i))
        }
        sum
    }
}


