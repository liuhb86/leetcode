import scala.collection.mutable.PriorityQueue
object Solution {
    def shortestDistance(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Int = {
        val d = (destination(0), destination(1))
        var q = PriorityQueue[(Int, Int, Int)]()(Ordering.by(-_._3))
        q += ((start(0), start(1), 0))
        maze(start(0))(start(1)) = 0
        while(q.nonEmpty) {
            val p = q.dequeue
            if (p._1 == d._1 && p._2 == d._2) return p._3
            if (-maze(p._1)(p._2) < p._3) {
                // do nothing
            }
            else {
                roll(maze, p, -1, 0,  q)
                roll(maze, p, 1, 0, q)
                roll(maze, p, 0, -1, q)
                roll(maze, p, 0, 1, q)
            }
        }
        -1
    }
    
    def roll(maze: Array[Array[Int]], p: (Int, Int, Int), dx: Int, dy: Int, q: PriorityQueue[(Int, Int, Int)]) {
        var x = p._1
        var y = p._2
        var d = p._3
        var x1 = x+dx; var y1 = y+dy
        while (x1>=0 && x1<maze.length && y1>=0 && y1<maze.head.length && maze(x1)(y1) != 1) {
            d += 1
            x = x1; y = y1;
            x1+=dx; y1+=dy
        }
        if (d==p._3) return
        if (maze(x)(y) < 0 && d >= -maze(x)(y)) return
        maze(x)(y) = -d
        q += ((x,y,d))
        //println(x,y,d)
    }
}