/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
        _construct(nums, 0, nums.length)
    }
    
    def _construct(nums: Array[Int], begin: Int, end: Int) : TreeNode = {
        if (begin >= end) null
        else {
            val maxIndex = indexOfMax(nums, begin, end)
            val node = new TreeNode(nums(maxIndex))
            node.left = _construct(nums, begin, maxIndex)
            node.right = _construct(nums, maxIndex + 1, end)
            node
        }
    }
    
    def indexOfMax(nums: Array[Int], begin: Int, end: Int) : Int = {
        var max = nums(begin)
        var maxIndex = begin
        for (i <- begin until end) {
            val v = nums(i)
            if (v > max) {
                max = v
                maxIndex = i
            }
        }
        maxIndex
    }
}