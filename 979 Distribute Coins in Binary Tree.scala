/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.math.abs
object Solution {
    def distributeCoins(root: TreeNode): Int = {
        dfs(root)._1
    }
    
    def dfs(root: TreeNode) : (Int, Int) = {
        if (root == null) return (0,0)
        val (lmove, lbal) = dfs(root.left)
        val (rmove, rbal) = dfs(root.right)
        (lmove+rmove+abs(lbal)+abs(rbal), lbal+rbal+root.value-1)
    }
}