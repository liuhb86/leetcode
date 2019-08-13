class TicTacToe(_n: Int) {

    /** Initialize your data structure here. */
    val r = Array.ofDim[Int](2,_n)
    val c = Array.ofDim[Int](2,_n)
    val d1 = new Array[Int](2)
    val d2 = new Array[Int](2)

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    def move(row: Int, col: Int, player: Int): Int = {
        val i = player - 1
        r(i)(row) += 1
        if (r(i)(row) == _n) return player
        c(i)(col) += 1
        if (c(i)(col) == _n) return player
        if (row ==col) {
            d1(i) += 1
            if (d1(i) == _n) return player
        }
        if (row+col == _n - 1) {
            d2(i) += 1
            if (d2(i) == _n) return player
        }
        0
    }

}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * var obj = new TicTacToe(n)
 * var param_1 = obj.move(row,col,player)
 */