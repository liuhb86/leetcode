object Solution {
    def movesToMakeZigzag(nums: Array[Int]): Int = {
        if (nums.length == 1) return 0
        var d1 = 0
        for (i<-0 until nums.length by 2) {
            val x1 = if (i<nums.length -1) 0.max(nums(i) - nums(i+1) + 1) else 0
            val x2 = if (i>0) 0.max(nums(i)-nums(i-1) + 1) else 0
            d1 += x1.max(x2)
        }
       var d2 = 0
        for (i<-1 until nums.length by 2) {
            val x1 = if (i<nums.length -1) 0.max(nums(i) - nums(i+1) + 1) else 0
            val x2 = 0.max(nums(i)-nums(i-1) + 1)
            d2 += x1.max(x2)
        }  
        //println(d1,d2)
        d1.min(d2)
    }
}