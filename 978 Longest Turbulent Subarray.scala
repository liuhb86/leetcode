import scala.math.signum
object Solution {
    def maxTurbulenceSize(A: Array[Int]): Int = {
        var m = 0
        var i = 0
        while (i<A.length) {
            if (i==A.length -1 || A(i+1)==A(i)) {
                m = m.max(1)
                i += 1
            } else {
                var e = i + 1
                while (e<A.length-1 
                           && signum(A(e)-A(e-1)) == signum(A(e)-A(e+1))) {
                        e += 1
                }
                m = m.max(e-i+1)
                i = e
            }
        }
        m
    }
}