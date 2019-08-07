// f(n, a) = 0.25*( f(n-4, a-1) + f(n-4,a-2) + f(n-4,a-3) + f(n-4,a-4)

import scala.collection.mutable.Map
object Solution {
    def soupServings(N: Int): Double = {
        if (N>=5000) return 1.0
        val cache = Map[(Int, Int), (Double, Double)]()
        val (x, y) = solve(N, N, cache)
        x+y/2.0
    }
    
    def solve(a: Int, b: Int, cache: Map[(Int, Int), (Double, Double)]) : (Double, Double) = {
        if (a<=0 && b<=0) return (0.0,1.0)
        if (a<=0) return (1.0, 0.0)
        if (b<=0) return (0.0,0.0)
        val c = cache.get((a, b))
        if (c.isDefined) return c.get
        val r1 = solve(a-100,b,cache)
        val r2 = solve(a-75, b-25, cache)
        val r3 = solve(a-50, b-50, cache)
        val r4 = solve(a-25, b-75, cache)
        val x = (r1._1+r2._1+r3._1+r4._1)/4.0
        val y = (r1._2+r2._2+r3._2+r4._2)/4.0
        cache((a,b)) = ((x,y))
        (x,y)
    }
}
