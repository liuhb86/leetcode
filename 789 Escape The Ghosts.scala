import scala.math.abs
object Solution {
    def escapeGhosts(ghosts: Array[Array[Int]], target: Array[Int]): Boolean = {
        if (ghosts.isEmpty) return true
        val m = ghosts.map(d(_, target)).min
        m > d(Array(0,0), target)
    }
    
    def d(a: Array[Int], b: Array[Int]) : Int = {
        abs(a(0)-b(0)) + abs(a(1)-b(1))
    }
}