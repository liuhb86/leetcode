object Solution {
    def wiggleSort(nums: Array[Int]): Unit = {
        var inc = true
        for (i<- 1 until nums.length) {
            if (inc && nums(i) < nums(i-1) 
               || !inc && nums(i) > nums(i-1)) {
                val t = nums(i); nums(i) = nums(i-1); nums(i-1) = t
            }
            inc = ! inc
        }
    }
}