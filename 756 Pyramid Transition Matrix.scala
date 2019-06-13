import scala.collection.mutable.{Map,Set}
object Solution {
    def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {
        val n = bottom.length
        val r = new Array[Array[Char]](n)
        for (i<-0 until n) {
            r(i) = new Array[Char](i+1)
        }
        for (i<-0 until n) {
            r(n-1)(i) = bottom(i)
        }
        val a = Map[(Char, Char),Set[Char]]()
        for (x<- allowed) {  
            val s = a.getOrElseUpdate((x(0),x(1)), Set[Char]())
            s += x(2)
        }
        new Solver(r,a).solve(n-2, 0)
    }
    
}

class Solver(r: Array[Array[Char]], a: Map[(Char, Char),Set[Char]]) {
    val n = r.length
    
    def solve(k: Int, i: Int) : Boolean = {
        if (i==n-1) return true
        val c1 = r(k+1)(i)
        val c2 = r(k+1)(i+1)
        if (!a.contains((c1,c2))) return false
        val (nk, ni) = if (i==0) (n-2, n-k-1) else (k-1, i-1)
        for(c<-a((c1,c2))) {
            r(k)(i) = c
            if (solve(nk, ni)) return true
        }
        false
    }
}