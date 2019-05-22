import scala.collection.mutable.ListBuffer
object Solution {
    def regionsBySlashes(grid: Array[String]): Int = {
        val n = grid.length
        val visited = Array.fill(n)(Array.fill(n)(new Array[Boolean](4)))
        val q = new ListBuffer[(Int, Int, Int)]
        var count = 0
        for (i <-0 until n) {
            for (j <- 0 until n) {
                for (k <- 0 until 4) {
                    if (!visited(i)(j)(k)) {
                        //println(s"*$i,$j,$k")
                        count += 1
                        visited(i)(j)(k) = true
                        q += ((i,j,k))
                        while (!q.isEmpty) {
                            val (x,y,z) = q.head
                            //println(s"$x,$y,$z")
                            q.trimStart(1)
                            val nextcell = z match {
                                case 0 => (x-1,y,2)
                                case 1 => (x,y+1,3)
                                case 2 => (x+1,y,0)
                                case 3=> (x,y-1,1)
                            }
                            val innercell = (grid(x)(y) match {
                                case ' '=>Seq((z+1)%4, (z+3)%4)
                                case '/' => Seq(3-z)
                                case '\\' => Seq(z+1-z%2*2)
                            }).map((x,y,_))
                            for ((a,b,c) <- innercell :+ nextcell) {
                                if (a >=0 && a < n && b>=0 && b<n
                                   && !visited(a)(b)(c)) {
                                    visited(a)(b)(c) = true
                                    q += ((a,b,c))
                                }
                            }
                        }
                    }
                }
            }
        }
        count
    }
}