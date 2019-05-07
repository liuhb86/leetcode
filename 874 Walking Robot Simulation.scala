import util.control.Breaks._

object Solution {
    def robotSim(commands: Array[Int], obstacles: Array[Array[Int]]): Int = {
        val obstaclesMap = obstacles.groupBy(_(0)).mapValues(_.map(_(1)).toSet)
        var x, y = 0
        var dx = 0
        var dy = 1
        var maxDistance = 0
        for (command <- commands) {
            command match {
                case -2 => val t = dy; dy = dx; dx = -t
                case -1 => val t = dy; dy = -dx; dx = t
                case _ => breakable {
                    for (s <- 1 to command) {
                        val nx = x + dx
                        val ny = y + dy
                        if (obstaclesMap.get(nx).map(_.contains(ny)) != Some(true)) {
                            x = nx
                            y = ny
                        } else {
                            break
                        }
                    }
                }
                val distance = x*x + y*y
                if (distance > maxDistance) maxDistance = distance
            }
        }
        maxDistance
    }
}