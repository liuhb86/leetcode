/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
object Solution {
    def findLeaves(root: TreeNode): List[List[Int]] = {
        val r = ArrayBuffer[ListBuffer[Int]]()
        dfs(root, r)
        r.toList.map(_.result)
    }
    
    def dfs(node: TreeNode, r: ArrayBuffer[ListBuffer[Int]]) : Int = {
        if (node == null) return -1
        val d1 = dfs(node.left, r)
        val d2 = dfs(node.right, r)
        val d = d1.max(d2) + 1
        if (d >= r.length) r += ListBuffer()
        r(d) += node.value
        d
    }
}