import scala.collection.mutable.ListBuffer
object Solution {
    def shortestBridge(A: Array[Array[Int]]): Int = {
        var foundFirst = false
        for(i<-A.indices; j<-A.head.indices) {
            if (A(i)(j) == 1) {
                if (foundFirst) return connect(A, i,j)
                else {foundFirst = true; flood(A,i,j)}
        }}
        throw new Exception()
    }
    
    def flood(A: Array[Array[Int]], i: Int, j: Int) {
        if (i<0 || i>= A.length) return
        if (j<0 || j>=A.head.length) return
        if (A(i)(j) != 1) return
        A(i)(j) = -1
        flood(A, i-1,j)
        flood(A, i+1,j)
        flood(A, i, j-1)
        flood(A, i, j+1)
    }
    
    def connect(A: Array[Array[Int]], i: Int, j: Int) : Int = {
        var len = 0
        var current = new ListBuffer[(Int,Int)]()
        border(A, i,j, current)
        while (current.nonEmpty) {
            //println(A.map(_.mkString(",")).mkString("\n"))
            //println(current.mkString(","))
            val next = new ListBuffer[(Int,Int)]()
            for ((i1,j1)<-current) {
                if (expand(A, i1-1,j1, next)) return len
                if (expand(A, i1+1,j1,next)) return len
                if (expand(A, i1, j1-1,next)) return len
                if (expand(A, i1, j1+1,next)) return len
            }
            current = next
            len += 1
        }
        throw new Exception()
    }
    
    def expand(A: Array[Array[Int]], i:Int, j: Int, r: ListBuffer[(Int,Int)]) : Boolean = {
        if (i<0 || i>= A.length) return false
        if (j<0 || j>=A.head.length) return false
        //println(s"x $i,$j ${A(i)(j)}")
        if (A(i)(j) == -1) return true
        if (A(i)(j) != 0) return false
        A(i)(j) = 2
        r += ((i,j))
        false
    }
    
    def border(A: Array[Array[Int]], i: Int, j: Int, r: ListBuffer[(Int,Int)]) : Boolean = {
        //println(s"y $i $j")
        if (i<0 || i>= A.length) return true
        if (j<0 || j>=A.head.length) return true
        if (A(i)(j) == 0) return true
        if (A(i)(j) != 1) return false 
        A(i)(j) = 2
        var b = false
        b |= border(A, i-1,j, r)
        b |= border(A, i+1,j,r)
        b |= border(A, i, j-1, r)
        b |= border(A, i,j+1, r)
        if (b) r += ((i,j))
        true
    }
        
}