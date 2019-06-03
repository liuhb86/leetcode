/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def findTilt(root: TreeNode): Int = {
       calc(root)._2
    }
    
    def calc(node: TreeNode) : (Int, Int) = {
        if (node == null) return (0,0)
        val l = calc(node.left)
        val r = calc(node.right)
        val s = node.value + l._1 + r._1
        val t = scala.math.abs(l._1 - r._1)
        (s, t + l._2 + r._2)
    }
}