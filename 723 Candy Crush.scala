object Solution {
    val m1 = 4096
    val m2 = 8192
    val m0 = m1 - 1
    
    def candyCrush(board: Array[Array[Int]]): Array[Array[Int]] = {
        if (board.isEmpty) return board
        val e = new Array[Int](board.head.length)
        var crushed = true
        //var d = 0
        while (crushed) {
            crushed = crush(board, e)
            drop(board, e)
            //println(board.map(_.mkString(" ")).mkString("\n"))
            //println()
            //d+=1
            //if (d==2) return board
        }
        board
    }
    
    def crush(board: Array[Array[Int]], e: Array[Int]) : Boolean = {
        var crushed = false
        val N = e.length
        val M = board.length
        for (j<- 0 until N) {
            for (i <- e(j) until M) {
                val v = board(i)(j) & m0
                if ((v & m1) == 0 && j < N-2
                    && (board(i)(j+1) & m0) == v
                    && (board(i)(j+2) & m0) == v) {
                    crushed = true
                    var k = j
                    while (k < N && (board(i)(k) & m0) == v) {
                        board(i)(k) |= m1
                        k += 1
                    }
                }
                if ((v & m2) == 0 && i < M-2
                    && (board(i+1)(j) & m0) == v
                    && (board(i+2)(j) & m0) == v) {
                    crushed = true
                    var k = i
                    while (k < M && (board(k)(j) & m0) == v) {
                        board(k)(j) |= m2
                        k += 1
                    }
                }
            }
        }
        crushed
    }
    
    def drop(board: Array[Array[Int]], e: Array[Int]) {
        val N = board.head.length
        val M = board.length
        for (j<-0 until N) {
            var x = M-1
            var y = M-1
            val L = e(j)
            while (x>=L) {
                while(y >= L && board(y)(j) > 0 &&  board(y)(j) <= m0) y-= 1
                x = x.min(y-1)
                while (x>=L && (board(x)(j) == 0 || board(x)(j) > m0) ) x-=1
                if (x>=L) {
                    board(y)(j) = board(x)(j)
                    board(x)(j) = 0
                    x-=1; y-=1
                }
                //println(j, x, y)
            }
            for (k <- L to y) board(k)(j) = 0
            e(j) = y + 1
        }
    }
}