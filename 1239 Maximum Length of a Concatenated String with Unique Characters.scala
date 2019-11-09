import scala.collection.mutable.Map
import scala.util.control.Breaks._
object Solution {
    def maxLength(arr: List[String]): Int = {
        val map = Map[(Int, Int), Int]()
        var arrf : List[(Int, Int)] = Nil
        for (s<- arr) {breakable {
            var mask = 0
            for (c<-s) {
                val m = 1 << (c-'a')
                if ((mask & m) != 0) break
                mask = mask | m
            }
            arrf = (mask, s.length) :: arrf
        }}
        solve(arrf, arrf.length, 0, map)
    }
    
    def solve(arr: List[(Int, Int)], i: Int, mask: Int, map: Map[(Int, Int), Int]) : Int = {
        if (i == 0) return 0
        val e = map.get((i, mask))
        if (e.isDefined) return e.get
        var r = solve(arr.tail, i-1, mask, map)
        val (m, len) = arr.head
        if ((mask & m) == 0) {
            r = r.max(solve(arr.tail, i-1, mask | m, map) + len)
        }
        map((i, mask)) = r
        r
    }
}