import scala.annotation.tailrec
object Solution {
    def powerfulIntegers(x: Int, y: Int, bound: Int): List[Int] = {
        if (x == 1 && y ==1) return if (bound>=2) List(2) else Nil
        if (x == 1) return p2(y, bound, 1, Nil)
        if (y==1) return p2(x, bound, 1, Nil)
        val r = scala.collection.mutable.Set[Int]()
        var i = 1
        while(i<=bound) {
            var j = 1
            var p = i + j
            while(p <= bound) {
                r += p
                j *= y
                p = i + j
            }
            i *= x
        }
        r.toList
    }
    
    @tailrec
    def p2(x: Int, bound:Int, t: Int, acc: List[Int]) : List[Int]= {
        if (t >= bound) acc
        else p2(x, bound, t*x, (t +1)::acc)
    }
}