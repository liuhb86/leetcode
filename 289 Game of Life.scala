import scala.util.control.Breaks._
object Solution {
    def gameOfLife(board: Array[Array[Int]]): Unit = {
        for (i<-board.indices) {
            for (j<- board(i).indices) {
                var n = 0
                 for (x<- -1 to 1; y<- -1 to 1) { breakable {
                    if (x==0 && y==0) break
                    val a = i+x
                    val b = j+y
                    if (a<0 || a>=board.length) break
                    if (b<0 || b>=board(i).length) break
                    val v = board(a)(b) & 1
                    if (v==1) n+=1
                }}
                val nv = if (n< 2 || n>3) 0
                    else if (n==3) 1
                    else board(i)(j)
                board(i)(j) |= (nv << 1)
            }
        }
         for (i<-board.indices) {
            for (j<-board(i).indices) {
                board(i)(j) >>= 1
            }
         }
    }
}