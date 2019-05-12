object Solution {
    def isRobotBounded(instructions: String): Boolean = {
        val visited = scala.collection.mutable.Set[(Int, Int, Int, Int)]()
        var x = 0
        var y = 0
        var dx = 0
        var dy = -1
        visited += ((x, y, dx, dy))
        for (r <- 1 to 4) {
            for (i <- instructions) {
                i match {
                    case 'G' => x += dx; y+=dy
                    case 'L' => val t = dx; dx = dy; dy = -t
                    case 'R' => val t = dx; dx = -dy; dy = t
                }
            }
            if (visited.contains((x,y, dx, dy))) return true
            visited += ((x,y, dx, dy))
        }
        false
    }
}