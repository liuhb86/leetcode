import scala.util.control.Breaks._
object Solution {
    def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
        val Array(x,y) = click
        if (board(x)(y)=='M') {
            board(x)(y) = 'X'
            return board
        }
        var q = List((x,y))
        board(x)(y) = 'B'
        
        while (!q.isEmpty) {
            val (a,b) = q.head ; q = q.tail
            var c = 0
            for (i<- -1 to 1; j<- -1 to 1) { breakable {
                if (i==0 && j== 0) break
                val (a1,b1) = (a+i, b+j)
                if (a1<0 || a1>=board.length) break
                if (b1<0 || b1>=board.head.length) break
                if (board(a1)(b1) == 'M') c+=1
                
            }}
            if (c>0) {
                board(a)(b) = ('0'+c).toChar
            } else {
                for (i<- -1 to 1; j<- -1 to 1) { breakable {
                    if (i==0 && j== 0) break
                    val (a1,b1) = (a+i, b+j)
                    if (a1<0 || a1>=board.length) break
                    if (b1<0 || b1>=board.head.length) break
                    if (board(a1)(b1) == 'E') {
                        board(a1)(b1) = 'B'
                        q = (a1,b1) :: q
                    }
                }}
            }
        }
        
        board
    }
    
}