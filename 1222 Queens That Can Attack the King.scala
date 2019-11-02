object Solution {
    def queensAttacktheKing(queens: Array[Array[Int]], king: Array[Int]): List[List[Int]] = {
        var result : List[List[Int]] = Nil
        val qset = queens.map(x=> (x(0), x(1))).toSet
        for (dx <- -1 to 1; dy <- -1 to 1 if dx!= 0 || dy!= 0) {
            var x = king(0)
            var y = king(1)
            while (x>=0 && x<8 && y>=0 && y<8 && !qset((x,y))) {
                x+=dx
                y+=dy
            }
            if (qset((x,y))) result = List(x,y) :: result
        }
        result
    }
}