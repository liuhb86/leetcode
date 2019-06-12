import scala.util.control.Breaks._
object Solution {
    def numRookCaptures(board: Array[Array[Char]]): Int = {
        val (y,x) = board.map(x=>x.indexOf('R')).zipWithIndex.filter(_._1 >= 0).head
        //println(s"$x,$y")
        var c = 0
        breakable{for (i<-x+1 until 8) {
            if (board(i)(y) != '.') {
                if (board(i)(y) =='p') c +=1
                break
            }
        }}
         breakable{for (i<-x-1 to 0 by -1) {
            if (board(i)(y) != '.') {
                if (board(i)(y) =='p') c +=1
                break
            }
        }}
         breakable{for (i<-y+1 until 8) {
            if (board(x)(i) != '.') {
                if (board(x)(i) =='p') c +=1
                break
            }
        }}
         breakable{for (i<-y-1 to 0 by -1) {
            if (board(x)(i) != '.') {
                if (board(x)(i) =='p') c +=1
                break
            }
        }}
        c
    }
}