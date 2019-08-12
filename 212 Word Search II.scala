import scala.collection.mutable.Set
object Solution {
    def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
        val start = Array.fill[List[(Int, Int)]](26)(Nil)
        for (i<- board.indices; j<- board(i).indices) {
            val c = board(i)(j)-'a'
            start(c) = (i,j) :: start(c)
        }
        words.filter(w=>find(w, board, start)).toList
    }
    
    def find(w: String, board: Array[Array[Char]], start: Array[List[(Int, Int)]]) : Boolean = {
        val s = start(w.head-'a')
        for((i,j)<-s) {
            val visited = Set[(Int, Int)]()
            if (find(w, board, i, j, 0, visited)) return true 
        }
        false
    }
    
    def find(w: String, board: Array[Array[Char]], i: Int, j: Int, k: Int, visited: Set[(Int, Int)]) : Boolean = {
        if (k == w.length) return true
        if (i<0 || i>= board.length) return false
        if (j<0 || j>=board(i).length) return false
        if (w(k) != board(i)(j)) return false
        if (visited((i,j))) return false
        visited += ((i,j))
        if (find(w, board,i,j+1, k+1, visited)) return true
        if (find(w, board, i,j-1,k+1, visited)) return true
        if (find(w, board, i-1,j, k+1, visited)) return true
        if (find(w, board, i+1, j, k+1, visited)) return true
        visited -= ((i,j))
        false
    }
}