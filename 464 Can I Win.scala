import scala.collection.mutable.Map
import scala.util.control.Breaks._
object Solution {
    def canIWin(m: Int, d: Int): Boolean = {
        if (m*(m+1)/2<d) return false
        if (d<=0) return true
        val map = Map[(Int, Int), Boolean]()
        val leftArr = (1 to m).toArray
        solve(d, leftArr, m, 0, map)
    }
    
    def solve(d: Int, arr: Array[Int], k: Int, bit: Int, map: Map[(Int, Int), Boolean]) : Boolean = {
        if (d<=0) return false
        val cached = map.get((d, bit))
        if (cached.isDefined) return cached.get
        var canWin = false
        breakable { for(i<-0 until k) {
            val c = arr(i)
            arr(i) = arr(k-1)
            val b = solve(d-c, arr, k-1, bit | (1 << c), map)
            arr(i) = c
            if (!b) {
                canWin = true
                break
            }
        }}
        map((d, bit)) = canWin
        canWin
    }
}