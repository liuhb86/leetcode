/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def bstFromPreorder(preorder: Array[Int]): TreeNode = {
        bst(preorder, 0, None)._1
    }
    
    def bst(preorder: Array[Int], begin: Int, bound: Option[Int]) : (TreeNode, Int) = {
        if (begin >= preorder.length) return (null, begin)
        if (bound.isDefined && preorder(begin) > bound.get) return (null, begin)
        val v = preorder(begin)
        val root = new TreeNode(v)
        val lr = bst(preorder, begin + 1, Some(v))
        root.left = lr._1
        val rr = bst(preorder, lr._2, bound)
        root.right = rr._1
        (root, rr._2)
    }
}