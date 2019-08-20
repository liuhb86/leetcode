import scala.collection.mutable.ListBuffer
object Solution {
    def hasPath(maze: Array[Array[Int]], start: Array[Int], destination: Array[Int]): Boolean = {
        val d = (destination(0), destination(1))
        var q = ListBuffer((start(0), start(1)))
        maze(start(0))(start(1)) = 2
        while(q.nonEmpty) {
            val p = q.head
            q.trimStart(1)
            if (roll(maze, p, -1, 0, d, q)) return true
            if (roll(maze, p, 1, 0, d, q)) return true
            if (roll(maze, p, 0, -1, d, q)) return true
            if (roll(maze, p, 0, 1, d, q)) return true
        }
        false
    }
    
    def roll(maze: Array[Array[Int]], p: (Int, Int), dx: Int, dy: Int, dest: (Int, Int), q: ListBuffer[(Int, Int)]): Boolean  = {
        var x = p._1
        var y = p._2
        var x1 = x+dx; var y1 = y+dy
        while (x1>=0 && x1<maze.length && y1>=0 && y1<maze.head.length && maze(x1)(y1) != 1) {
            x = x1; y = y1;
            x1+=dx; y1+=dy
        }
        if (maze(x)(y) != 0) return false
        if (x==dest._1 && y==dest._2) return true
        maze(x)(y) = 2
        q += ((x,y))
        false
    }
}