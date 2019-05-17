object Solution {
    def findCircleNum(M: Array[Array[Int]]): Int = {
        val visited = new Array[Boolean](M.length)
        var count = 0
        for (i <- 0 until M.length) {
            if (!visited(i)) {
                count += 1
                flood(M, visited, i)
            }
        }
        count
    }
    
    def flood(M: Array[Array[Int]], visited: Array[Boolean], i : Int) : Unit = {
        visited(i) = true
        for (j <- 0 until M(i).length) {
            if (M(i)(j) == 1 && !visited(j)) {
                flood(M, visited, j)
            }
        }
    }
}