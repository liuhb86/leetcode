class NumMatrix(_matrix: Array[Array[Int]]) {
    
    for (i<-_matrix.indices) {
        var s = 0
        for (j<-_matrix(i).indices) {
            val p = if (i==0) 0 else _matrix(i-1)(j)
            s += _matrix(i)(j)
            _matrix(i)(j) = p + s
        }
    }
    
    def s(i:Int, j: Int) : Int= {
        if (i<0 || j<0) 0
        else _matrix(i)(j)
    }
    
    def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
        s(row2,col2) + s(row1-1,col1-1) - s(row1-1, col2) - s(row2, col1-1)
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */