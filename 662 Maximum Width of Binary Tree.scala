/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.ListBuffer
object Solution {
    def widthOfBinaryTree(root: TreeNode): Int = {
        if (root == null) return 0
        var maxWidth = 0
        var curQueue = new ListBuffer[(TreeNode, Int)]
        var nextQueue = new ListBuffer[(TreeNode, Int)]
        curQueue += ((root, 0))
        while (!curQueue.isEmpty) {
            val left = curQueue.head._2
            var right = left
            for ((node, position) <- curQueue) {
                right = position
                if (node.left != null) nextQueue += ((node.left, position << 1))
                if (node.right != null) nextQueue += ((node.right, (position << 1) + 1))
            }
            val width = right - left + 1
            if (width > maxWidth) maxWidth = width
            curQueue = nextQueue
            nextQueue = new ListBuffer[(TreeNode, Int)]
        }
        maxWidth
    }
}