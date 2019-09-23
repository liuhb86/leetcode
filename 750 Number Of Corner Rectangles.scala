import scala.collection.immutable.BitSet
object Solution {
    def countCornerRectangles(grid: Array[Array[Int]]): Int = {
        if (grid.length < 2 || grid.head.length < 2) return 0
        val bs = grid.map(x=> BitSet(x.zipWithIndex.filter(_._1==1).map(_._2):_*))
        var r = 0
        for (i<-bs.indices) {
            for (j<-0 until i) {
                val c = (bs(i) & bs(j)).size
                //println(i,j, c)
                if (c>=2) r += c* (c-1)/2
            }
        }
        r
    }
}