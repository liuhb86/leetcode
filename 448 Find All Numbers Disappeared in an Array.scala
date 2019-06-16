object Solution {
    def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
        var r : List[Int] = Nil
        for (i<-nums.indices) {
            var v = nums(i)
            nums(i) = -1
            while (v != -1) {
                val t = nums(v-1)
                if (t != v) {
                    nums(v-1) = v
                    v = t
                } else {
                    v = -1
                }
            }
        }
        for (i<-nums.indices.reverse) {
            if (nums(i) == -1) r = (i+1) :: r
        }
        r
    }
}