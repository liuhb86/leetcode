// k1 = (y1-y0)/(x1-x0)
// k2 = -k = (y0-y1)/(x1-x0)
// (y - y1) = k2(x-x1)   y-y1 = -dy * (x-x1) / dx
// p1 = (0, y1-x1*(y0-y1) / (x1-x0))
// p2 = ....
import scala.util.control.Breaks._
import scala.math.abs
object Solution {
    val eps = 1e-6
    def mirrorReflection(p: Int, q: Int): Int = {
        if (q==0) return 0
        if (q==p) return 1
        var r0 = (0.0,0.0)
        var r1 = (p.toDouble, q.toDouble)
        while(true) {
            val dx = r1._1 - r0._1
            val dy = r1._2 - r0._2
            val (x1,y1) = r1
            val rn1 = (0.0, x1* dy/dx+y1)
            val rn2 = (p.toDouble, (x1-p)*dy/dx+y1)
            val rn3 = (y1*dx/dy+x1, 0.0)
            val rn4 = ((y1-p)*dx/dy+x1, p.toDouble)
            var r : (Double, Double) = null
            breakable { for (r2<-Seq(rn1, rn2, rn3, rn4)) {
                if (r2==r0) {}
                else if (r2==r1) {}
                else if (r2._1 < -eps || r2._1>p+eps) {}
                else if (r2._2 < -eps || r2._2>p+eps) {}
                else {
                    if (eq(r2,(p,0))) return 0
                    if (eq(r2,(p,p))) return 1
                    if (eq(r2,(0,p))) return 2
                    r = r2
                    break
                }
            }}
            r0 = r1
            r1 = r
            println(r)
        }
        0
    }
    
    def eq(r1: (Double, Double), r2: (Double, Double)): Boolean = {
        abs(r1._1-r2._1) < eps && abs(r1._2 - r2._2) < eps
    }
}