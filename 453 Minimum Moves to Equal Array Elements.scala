object Solution {
    def minMoves(nums: Array[Inat]): Int = {
        nums.sum -nums.min* nums.length
    }
}