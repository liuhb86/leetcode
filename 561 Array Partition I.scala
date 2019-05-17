object Solution {
    def arrayPairSum(nums: Array[Int]): Int = {
        nums.sorted.zipWithIndex.filter(_._2 % 2 == 0).map(_._1).sum
    }
}