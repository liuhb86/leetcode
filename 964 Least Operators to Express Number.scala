import scala.math.min
object Solution {
    def leastOpsExpressTarget(x: Int, target: Int): Int = {
        val lx = x.toLong
        val lt = target.toLong
        var k = 0
        var xk = 1L
        while (xk <= lt) {
            k += 1
            xk *= lx
        }
        k -=1
        xk/=lx
        solve(lx, lt, k, xk, target*2) - 1
    }
    
    def solve(x: Long, target: Long, k: Int, xk: Long, ub: Int) : Int = {
        if (target == 0) return 0
        val n = if (k==0) 2 else k
        if (target==xk) return min(n, ub)
        var r = solvep(x, target, k, xk, ub)
        if (k+1 >= r) return r
        k+1 + solvep(x, x*xk-target, k, xk, min(r, ub) - k - 1)
    }
    
    def solvep(x: Long, target: Long, k: Int, xk: Long, ub: Int) : Int = {
        val n = if (k==0) 2 else k
        val a = (target / xk).toInt
        val an = a*n
        if (an>=ub) return ub
        an + solve(x, target-a*xk, k-1,xk/x,ub-an)
    }
}