// peek
import scala.collection.mutable.Map
object Solution {
    def minTransfers(transactions: Array[Array[Int]]): Int = {
        val m = Map[Int, Int]()
        for (Array(a,b,c) <- transactions) {
            m(a) = m.getOrElse(a,0) + c
            m(b) = m.getOrElse(b, 0) - c
        }
        val p = m.values.filter(_ != 0).toArray
        //println(p.mkString(" "))
        val n = p.length
        if (n == 0) return 0
        val dp = new Array[Int](1<<n)
        val s = new Array[Int](1<<n)
        for (i<-0 until 1 << n) {
            var b = 1
            //println(dp(i), s(i))
            for (j<-0 until n) {
                if ((i& b) == 0) {
                    val t = i | b
                    s(t) = s(i) + p(j)
                    if (s(t) == 0) dp(t) = dp(t).max(dp(i) + 1)
                    else dp(t) = dp(t).max(dp(i))
                }
                b <<= 1
            } 
        }
        n - dp((1<<n)-1)
    }
}