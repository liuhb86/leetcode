import scala.util.control.Breaks._
object Solution {
    def findKthNumber(n: Int, k: Int): Int = {
        var x = 0L
        var t = 0L
        while(t<k) {
            //println(x, t)
            var s = t + 1
            breakable { for (i<-0 to 9) {
                val x0 = x*10 + i
                var s0 = 0L
                var p = 1L
                if (x0==0) {s0=0}
                else {
                    while (x0*p<=n) {
                        if (x0*p + p -1 <= n) s0+= p
                        else s0 += n- x0*p+1
                        //println("c", x0*p, s0)
                        p*=10
                    }
                }
                if (s + s0 - 1 < k) {
                    s += s0
                    //println(x0,s0, s)
                } else {
                    x = x0
                    t = s
                    break
                }
            }}
        }
        x.toInt
    }
}