object Solution {
    def generatePossibleNextMoves(s: String): List[String] = {
        var r : List[String] = Nil
        val b = s.toArray
        for (i<-s.length -2 to 0 by -1) {
            if (s(i)=='+' && s(i+1)=='+') {
                b(i) = '-'; b(i+1)='-'
                r = b.mkString :: r
                b(i) = '+'; b(i+1)='+'
            }
        }
        r
    }
}