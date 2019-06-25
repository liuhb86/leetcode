import scala.collection.mutable.{Map,Set}
object Solution {
    def gridIllumination(N: Int, lamps: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
        val l = Set[(Int, Int)]()
        val cx = Map[Int, Int]()
        val cy = Map[Int, Int]()
        val cd = Map[Int, Int]()
        val cdr = Map[Int, Int]()
        for (Array(x,y)<-lamps) {
            l += ((x,y))
            cx(x) = cx.getOrElse(x,0) + 1
            cy(y) = cy.getOrElse(y,0) + 1
            cd(x-y) = cd.getOrElse(x-y,0) +1
            cdr(x+y) = cdr.getOrElse(x+y,0) +1
        }
        val r = new Array[Int](queries.length)
        for (i<-queries.indices) {
            val (x,y) = (queries(i)(0), queries(i)(1))
            r(i) = if (cx.getOrElse(x,0) > 0 || cy.getOrElse(y,0) > 0 || cd.getOrElse(x-y,0)>0 || cdr.getOrElse(x+y,0) > 0) 1 else 0
            for (dx<- -1 to 1; dy<- -1 to 1) {
                val (nx, ny) = (x+dx, y+dy)
                if (l.contains((nx, ny))) {
                    l -= ((nx, ny))
                    cx(nx) -=1
                    cy(ny) -=1
                    cd(nx-ny) -=1
                    cdr(nx+ny) -=1
                }
            }
        }
        r
    }
}