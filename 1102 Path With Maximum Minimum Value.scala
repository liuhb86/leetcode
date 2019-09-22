import scala.collection.mutable.PriorityQueue
object Solution {
    def maximumMinimumPath(A: Array[Array[Int]]): Int = {
        val pq = PriorityQueue[(Int, Int, Int)]()(Ordering.by(_._3))
        pq += ((0,0,A(0)(0)))
        A(0)(0) = -1
        while(true) {
            val(i,j, v) = pq.dequeue
            if (visit(i-1,j, v,A,pq)) return -A(A.length-1)(A.head.length-1) -1
            if (visit(i+1,j,v,A,pq)) return -A(A.length-1)(A.head.length-1) -1
            if (visit(i,j-1,v,A,pq)) return -A(A.length-1)(A.head.length-1) -1
            if (visit(i,j+1,v,A,pq)) return -A(A.length-1)(A.head.length-1) -1
        }
        -1
    }
    
    def visit(i: Int, j: Int, v: Int,
              A: Array[Array[Int]], 
              pq: PriorityQueue[(Int, Int, Int)]) : Boolean = {
        if (i<0 || i>=A.length) return false
        if (j<0 || j>=A(i).length) return false
        if (A(i)(j) <0) return false
        val d = v.min(A(i)(j))
        pq += ((i, j, d))
        A(i)(j)  = -(d+1)
        i == A.length - 1 && j == A.head.length -1 
    }
}