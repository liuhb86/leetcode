object Solution {
    def alphabetBoardPath(target: String): String = {
        var p = (0,0)
        val r = new scala.collection.mutable.StringBuilder()
        for (c<-target) {
            val p2 = pos(c)
            val dx = p2._1 - p._1
            val dy = p2._2 - p._2
            if (dy<0) for (i<- 1 to -dy) r+= 'L'
            if (dx<0) for (i<-1 to -dx) r += 'U'
            if (dx > 0) for (i<- 1 to dx) r += 'D'
            if (dy > 0) for (i <- 1 to dy) r+= 'R'
            
            r += '!'
            p = p2
        }
        r.toString
    }
    
    def pos(c: Char) : (Int, Int) = {
        val x = c - 'a'
        (x / 5, x % 5)
    }
}