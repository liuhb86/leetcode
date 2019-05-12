object Solution {
    def findDuplicates(nums: Array[Int]): List[Int] = {
        var result : List[Int] = Nil
        for (i<- 0 until nums.length) {
            var k = nums(i)  
            nums(i) = -1
            while (k != -1) {
                if (nums(k - 1) == k) {
                    result ::= k
                    k = -1
                } else {
                    val n = nums(k - 1)
                    nums(k - 1) = k
                    k = n
                }
            }
        }
        result
    }
}