object Solution {
    def countBattleships(board: Array[Array[Char]]): Int = {
        var count = 0
        for (x <- 0 until board.length) {
            for (y<- 0 until board(x).length) {
                if (isShip(board, x,y) 
                    && !isShip(board, x, y-1) 
                    && !isShip(board, x-1, y)) {
                    count += 1
                }
            }
        }
        count
    }
    
    def isShip(board: Array[Array[Char]], x: Int, y: Int) : Boolean = {
        if (x<0 || x>= board.length) return false
        if (y<0 || y >= board(x).length) return false
        return board(x)(y) == 'X'
    }
}