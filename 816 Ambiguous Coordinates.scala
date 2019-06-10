import scala.collection.mutable.ListBuffer
object Solution {
    def ambiguousCoordinates(S: String): List[String] = {
        val s = S.substring(1, S.length-1)
        val r = new ListBuffer[String]()
        for (i<- 1 until s.length) {
            gen(s.take(i), s.drop(i), r)
        }
        r.toList
    }
    
    def gen(x: String, y: String, r: ListBuffer[String]) {
        if (invalid(x) || invalid(y)) return
        val xc = genNum(x)
        val yc = genNum(y)
        for (ix<-xc;iy<-yc) {
            r += s"($ix, $iy)"
        }
    }
    
    def invalid(x: String) : Boolean = {
        x.length > 1 && x.head == '0' && x.last =='0'
    }
    
    def genNum(x: String) : List[String] = {
        if (x.last == '0') return List(x)
        if (x(0)=='0') return List(s"0.${x.tail}")
        val r = for (i<-1 until x.length) yield s"${x.take(i)}.${x.drop(i)}"
        x:: r.toList
    }
}