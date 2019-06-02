class NumArray(_nums: Array[Int]) {

    val s = new Array[Int](_nums.length + 1) 
    init()
    
    def init() {
        s(0) = 0
        for (i <- 0 until _nums.length) {
            s(i + 1) = _nums(i) + s(i)
        }
    }
    
    def sumRange(i: Int, j: Int): Int = {
        s(j+1) - s(i)
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */