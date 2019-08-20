import scala.math.abs
object Solution {
    def assignBikes(workers: Array[Array[Int]], bikes: Array[Array[Int]]): Array[Int] = {
        val r = Array.fill(workers.length)(-1)
        val assigned = new Array[Boolean](bikes.length)
        var c = 0
        val q = Array.fill[List[(Int, Int)]](2001)(Nil)
        for (i<-workers.length - 1 to 0 by -1) {
            for (j<-bikes.length -1 to 0 by -1) {
                val d = abs(workers(i)(0)-bikes(j)(0)) + abs(workers(i)(1)-bikes(j)(1))
                q(d) = (i, j) :: q(d)
            }
        }
        for (d<- 1 to 2000) {
            for((i,j)<- q(d)) {
                //println(d, i, j)
                if (r(i) < 0 && !assigned(j)) {
                    c+=1
                    r(i) = j
                    assigned(j) = true
                    if (c == workers.length) return r
                }
            }
        }
        r
    }
}