/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def findMode(root: TreeNode): Array[Int] = {
        find(root).modes
    }
    
    def find(root: TreeNode): Result = {
        if (root == null) return Result(Array(), 0, 0, 0, 0, 0)
        val v = root.value
        
        val left = find(root.left)
        val right = find(root.right)
        
        val min = if (left.minCount == 0) v else left.min
        var minCount = left.minCount
        if (v == min) minCount += 1
        if (right.min == min) minCount += right.minCount
        
        val max = if (right.maxCount == 0) v else right.max
        var maxCount = right.maxCount
        if (v == max) maxCount += 1
        if (left.max == max) maxCount += left.maxCount
        
        var rootCount = 1
        if (v == left.max) rootCount += left.maxCount
        if (v == right.min) rootCount += right.minCount
        
        val modeCount = scala.math.max(scala.math.max(left.modeCount, right.modeCount), rootCount)
        var modes : Array[Int]= Array()
        if (rootCount == modeCount) modes :+= v
        if (left.modeCount == modeCount) modes ++=  left.modes
        if (right.modeCount == modeCount) modes ++= right.modes
        
        Result(modes, modeCount, min, minCount, max, maxCount)
    }
    
}

case class Result(
    modes: Array[Int],
    modeCount : Int,
    min: Int,
    minCount: Int,
    max: Int,
    maxCount: Int
)