import scala.util.control.Breaks._
object Solution {
    val M = 1L << 31
    def splitIntoFibonacci(S: String): List[Int] = {
        breakable {for (i<-1 to 10) {
            if (i>=S.length) break
            if (S(0)=='0' && i > 1) break
            val a = S.substring(0,i).toLong
            if (a >= M) break
            breakable{ for (j<-i+1 to i+10) {
                if (j>=S.length) break
                if (S(i)=='0' && j > i+1) break
                val b = S.substring(i,j).toLong
                if (b>=M) break
                val r = sat(S,a,b,j)
                if (r != Nil) return r
            }}
        }}
        Nil
    }
    
    def sat(S: String, a0: Long, b0: Long, j0: Int) : List[Int] = {
        var a = a0
        var b = b0
        var j = j0
        var r = List(b,a)
        while(j<S.length) {
            //if (a0==28 && b0==200) println(s"$a $b")
            val c = a+b
            if (c >=M) return Nil
            val cs = c.toString
            if (j + cs.length > S.length) return Nil
            for (i<-0 until cs.length) {
                if (S(j+i) != cs(i)) return Nil
            }
            r = c :: r
            j = j + cs.length
            a = b; b = c
        }
        r.reverse.map(_.toInt)
    }
}