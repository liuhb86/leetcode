object Solution {
    def pourWater(heights: Array[Int], V: Int, K: Int): Array[Int] = {
        for (i<-1 to V) {
            if (!pour(-1, heights, K, heights(K)) && !pour(1, heights, K, heights(K))) {
                heights(K) += 1
            }
        }
        heights
    }
    
    def pour(dir: Int, heights: Array[Int], i: Int, limit: Int) : Boolean = {
        if (i<0 || i >=heights.length) return false
        if (heights(i) > limit) return false
        if (heights(i) == limit) return pour(dir, heights, i+dir, limit)
        // heights(i) < limit
        if (!pour(dir, heights, i+dir, heights(i))) {
            heights(i) += 1
        }
        true
    }
}