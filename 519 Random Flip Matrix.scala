class Solution(_n_rows: Int, _n_cols: Int) {
    val redirect = scala.collection.mutable.Map[Int, Int]()
    var n = _n_rows * _n_cols
    
    def flip(): Array[Int] = {
        val k = scala.util.Random.nextInt(n)
        val rk = redirect.getOrElse(k,k)
        val rr = redirect.getOrElse(n-1, n-1)
        redirect(k) = rr
        n -= 1
        Array(rk / _n_cols, rk % _n_cols)
    }
    

    def reset() {
        redirect.clear()
        n = _n_rows * _n_cols
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(n_rows, n_cols)
 * var param_1 = obj.flip()
 * obj.reset()
 */