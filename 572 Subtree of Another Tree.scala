/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
        val ht = height(t)
        _isSubtree(s,t, ht)._1
    }
    
    def _isSubtree(s: TreeNode, t: TreeNode, ht: Int) : (Boolean, Int) = {
        if (s == null) return (t== null, 0)
        val left = _isSubtree(s.left,t, ht)
        if (left._1) return (true,-1)
        val right = _isSubtree(s.right,t,ht)
        if (right._1) return (true,-1)
        val h = scala.math.max(left._2, right._2) + 1
        if (h == ht) 
            (isSame(s, t), h)
         else 
            (false, h)
    }
    
    def isSame(s: TreeNode, t: TreeNode) : Boolean = {
        if (s == null && t == null) true
        else if (s == null || t == null) false
        else s.value == t.value && isSame(s.left, t.left) && isSame(s.right, t.right)
    }
    
    def height(n: TreeNode) : Int = {
        if (n == null) 0
        else scala.math.max(height(n.left), height(n.right)) + 1
    } 
}