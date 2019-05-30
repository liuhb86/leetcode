import scala.collection.mutable.Map
object Solution {
    def leastBricks(wall: List[List[Int]]): Int = {
        val map = Map[Int, Int]()
        for (w <- wall) {
            var s = 0
            for (b<-w) {
                if (s > 0) map(s) = map.getOrElse(s, 0) + 1
                s += b
            }
        }
        if (map.isEmpty) return wall.length
        wall.length - map.maxBy(_._2)._2
    }
}