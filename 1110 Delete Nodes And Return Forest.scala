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
    def delNodes(root: TreeNode, to_delete: Array[Int]): List[TreeNode] = {
        val r = ListBuffer[TreeNode]()
        val newRoot = del(root, to_delete.toSet, r)
        if (newRoot != null) r += newRoot
        r.toList
    }
    
    def del(node: TreeNode, to_delete: Set[Int], r: ListBuffer[TreeNode]) : TreeNode = {
        if (node == null) return null
        node.left = del(node.left, to_delete, r)
        node.right = del(node.right, to_delete, r)
        if (to_delete.contains(node.value)) {
            if (node.left != null) r += node.left
            if (node.right != null) r += node.right
            null
        } else {
            node
        }
    }
}