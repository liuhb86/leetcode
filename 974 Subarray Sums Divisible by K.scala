import scala.collection.mutable
object Solution {
    def subarraysDivByK(A: Array[Int], K: Int): Int = {
        val map = mutable.Map[Int, Int]()
        map(0) = 1
        var result = 0
        var sum = 0
        for (n <- A) {
            sum += n
            val r = (sum % K + K) % K
            val p = map.getOrElse(r, 0)
            result += p
            map (r) = p + 1
            //println(s"$sum, $r, ${map.getOrElse(r,0)}")
        }
        result
    }
}