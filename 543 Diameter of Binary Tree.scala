/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

import scala.math.max
object Solution {
    def diameterOfBinaryTree(root: TreeNode): Int = {
        max(solve(root).maxPath - 1, 0)
    }
    
    def solve(node: TreeNode) : Length = {
        if (node == null) Length(0,0)
        else {
            val leftLength = solve(node.left)
            val rightLength = solve(node.right)
            val maxToRoot = max(leftLength.maxToRoot, rightLength.maxToRoot) + 1
            val maxPath = Seq(leftLength.maxPath, rightLength.maxPath, leftLength.maxToRoot + rightLength.maxToRoot + 1).max
            Length(maxToRoot, maxPath)
        }
    }
}

case class Length(maxToRoot: Int, maxPath: Int)