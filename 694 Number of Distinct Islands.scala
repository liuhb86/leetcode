object Solution {
    def numDistinctIslands(grid: Array[Array[Int]]): Int = {
        val set = scala.collection.mutable.Set[List[Long]]()
        for (i<-grid.indices) {
            for (j<-grid(i).indices) {
                if (grid(i)(j)==1) {
                    val s = new Array[Long](grid.length)
                    flood(grid, i, j, s, i, j)
                    val sl = s.toList
                    set += sl
                }
            }
        }
        //set.foreach(println(_))
        set.size
    }
    
    def flood(grid: Array[Array[Int]], i: Int, j: Int, s: Array[Long], i0: Int, j0: Int) {
        if (i<0 || i>=grid.length) return
        if (j<0 || j>=grid(i).length) return
        if (grid(i)(j)!= 1) return
        grid(i)(j) = 2
        val i1 = i-i0
        val j1 = (j -j0 + grid(i).length) % grid(i).length
        s(i1) = s(i1) | (1<<j1)
        flood(grid, i-1, j,s, i0,j0)
        flood(grid, i+1,j,s,i0,j0)
        flood(grid, i,j-1,s,i0,j0)
        flood(grid, i,j+1,s,i0,j0)
    }
}