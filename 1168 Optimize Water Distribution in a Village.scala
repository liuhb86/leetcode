import scala.collection.mutable.TreeSet
object Solution {
    def minCostToSupplyWater(n: Int, wells: Array[Int], pipes: Array[Array[Int]]): Int = {
        val g = Array.fill[List[(Int, Int)]](n)(Nil)
        for (Array(_x,_y,c)<-pipes) {
            val x = _x -1; val y = _y-1
            g(x) = (y,c) :: g(x)
            g(y) = (x,c) :: g(y)
        }
        val ts = TreeSet(wells.zipWithIndex:_*)
        var r = 0
        while (ts.nonEmpty) {
            //println(ts.map(x=>(x._1,x._2+1)).mkString)
            val e = ts.head
            ts -= e
            val (c, i) = e
            r += c
            wells(i) = -1
            for ((x, p)<-g(i)) {
                if (p < wells(x)) {
                    ts -= ((wells(x), x))
                    ts += ((p,x))
                    wells(x) = p
                }
            }
        }
        r
    }
}