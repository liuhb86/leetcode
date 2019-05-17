// https://leetcode.com/problems/magic-squares-in-grid/discuss/133874/Python-5-and-43816729
object Solution {
    val pattern = Array(4,3,8,1,6,7,2,9,4,3,8,1,6,7,2,9)
    val patternIndex = Array(-1,3,6,1,0,-1,4,5,2,7)
    val offset1 = Array((1,0), (1,0), (0,1), (0,1), (-1,0), (-1,0), (0,-1), (0,-1))
    val offset2 = offset1.map{case(x,y) => (y,x)}
    
    def numMagicSquaresInside(grid: Array[Array[Int]]): Int = {
        var count = 0
        for (i<- 1 until grid.length -1) {
            for (j <- 1 until grid(i).length -1) {
                if (check(grid, i, j)) count += 1
            }
        }
        count
    }
    
    def check(grid: Array[Array[Int]], i: Int, j: Int) : Boolean = {
        if (grid(i)(j) != 5) return false
        var x = i -1
        var y = j -1
        val topLeft = grid(x)(y)
        if (topLeft < 1 || topLeft > 9 || topLeft == 5) return false
        val top = grid(x + 1)(y)
        var index = patternIndex(topLeft)
        val offset = 
            if (top == pattern(index + 1)) offset1
            else offset2
        for (k <- 0 until 8) {
            index += 1
            x += offset(k)._1
            y += offset(k)._2
            if (grid(x)(y) != pattern(index)) return false
        }
        true
    }
}