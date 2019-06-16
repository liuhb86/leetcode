object Solution {
    def complexNumberMultiply(a: String, b: String): String = {
        val (x,y) = (parse(a), parse(b))
        val rr = x._1 * y._1 - x._2 * y._2
        val ri = x._2 * y._1 + x._1 * y._2
        s"$rr+${ri}i"
    }
    
    val p = raw"(-?\d+)\+(-?\d+)i".r
    
    def parse(x: String) : (Int, Int) = {
        x match {
            case p(r, i) => (r.toInt,i.toInt)
        }
    }
}