object Solution {
    def judgeCircle(moves: String): Boolean = {
        val s = moves.groupBy(identity).mapValues(_.length)
        s.getOrElse('U',0) == s.getOrElse('D',0) && 
            s.getOrElse('L',0) == s.getOrElse('R',0)
    }
}