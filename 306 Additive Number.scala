import scala.util.control.Breaks._
import scala.math.BigInt
object Solution {
    def isAdditiveNumber(num: String): Boolean = {
        val S = num
        breakable {for (i<-1 to S.length/2) {
            if (S(0)=='0' && i > 1) break
            val a = BigInt(S.substring(0,i))
            breakable{ for (j<-i+1 until S.length.min((S.length+ i)/2 + 1)) {
                if (S(i)=='0' && j > i+1) break
                val b = BigInt(S.substring(i,j))
                if (sat(S,a,b,j)) return true
            }}
        }}
        false
    }
    
    def sat(S: String, a0: BigInt, b0: BigInt, j0: Int) : Boolean= {
        var a = a0
        var b = b0
        var j = j0
        while(j<S.length) {
            //if (a0==28 && b0==200) println(s"$a $b")
            val c = a+b
            val cs = c.toString
            if (j + cs.length > S.length) return false
            for (i<-0 until cs.length) {
                if (S(j+i) != cs(i)) return false
            }
            j = j + cs.length
            a = b; b = c
        }
        true
    }
}