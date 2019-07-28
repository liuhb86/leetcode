/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.ArrayBuffer
object Solution {
    def rightSideView(root: TreeNode): List[Int] = {
        val r = ArrayBuffer[Int]()
        dfs(root, 0, r)
        r.toList
    }
    
    def dfs(node: TreeNode, d: Int, r: ArrayBuffer[Int]) {
        if (node == null) return
        if (d >= r.length) {
            r += node.value
        } else {
            r(d) = node.value
        }
        dfs(node.left, d+1, r)
        dfs(node.right, d+1, r)
    }
}