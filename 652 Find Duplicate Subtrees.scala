/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.{Map, Set, ListBuffer}
object Solution {
    def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
        val hash = Map[(Int, Int), ListBuffer[TreeNode]]()
        val r = Set[TreeNode]()
        find(root, hash, r)
        r.toList
    }
    
    def find(node: TreeNode, hash: Map[(Int, Int), ListBuffer[TreeNode]], r: Set[TreeNode]) : Int = {
        if (node == null) return 0
        var height = find(node.left, hash, r)
        height = height.max(find(node.right, hash, r))
        height += 1
        val h = hash.getOrElseUpdate((height, node.value), ListBuffer[TreeNode]())
        for (t<- h) {
            if (isSame(t, node)) {
                if (!r.contains(t)) r += t
                return height
            }
        }
        h += node
        height
    }
    
    def isSame(a: TreeNode, b: TreeNode) : Boolean = {
        if (a == null && b == null) return true
        if (a == null || b == null) return false
        a.value == b.value && isSame(a.left, b.left) && isSame(a.right, b.right)
    }
}