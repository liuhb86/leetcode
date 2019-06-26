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
    def distanceK(root: TreeNode, target: TreeNode, K: Int): List[Int] = {
        val r = new ListBuffer[Int]()
        var path = null :: find(root, target).reverse
        var i = K
        while (i >=0 && path.tail != Nil) {
            val avoid = path.head
            path = path.tail
            collect(path.head, i, avoid, r)
            i -= 1
        }
        r.toList
    }
    
    def collect(root: TreeNode, K: Int, avoid: TreeNode, r: ListBuffer[Int]) {
        if (root == null || root == avoid) return
        if (K==0) {r += root.value; return}
        collect(root.left, K-1, avoid, r)
        collect(root.right, K-1, avoid,r)
    }
    
    def find(root: TreeNode, target: TreeNode) : List[TreeNode] = {
        if (root == null) return Nil
        if (root == target) return List(root)
        val left = find(root.left, target)
        if (left != Nil) return root:: left
        val right = find(root.right, target)
        if (right != Nil) return root :: right
        Nil
    }
}