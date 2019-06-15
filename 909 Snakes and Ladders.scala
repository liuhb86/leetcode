object Solution {
    def snakesAndLadders(board: Array[Array[Int]]): Int = {
        val n = board.length
        if (n <=1) return 0
        val m = n* n
        val visited = new Array[Boolean](m+1)
        visited(1) = true
        var current = List(1)
        var move = 0
        while (current != Nil) {
            var next: List[Int] = Nil
            for (x<-current) {
                if (x==m) return move
                for (i<-1 to 6) {
                    var s = x + i
                    if (s <= m) {
                        val r0 = (s-1) / n
                        val r = n - 1 - r0
                        var c = (s-1) % n
                        if (r0 % 2 == 1) c = n - 1 - c
                        if (board(r)(c)!= -1) s = board(r)(c)
                        if (!visited(s)) {
                            visited(s) = true
                            next = s :: next
                        }
                    }
                }
            }
            current = next
            move += 1
        }
        -1
    }
}