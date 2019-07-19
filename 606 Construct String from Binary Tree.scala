/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def tree2str(t: TreeNode): String = {
        val r = new scala.collection.mutable.StringBuilder()
        dfs(t, r)
        r.toString
    }
    
    def dfsc(t: TreeNode, r: StringBuilder) {
        r += '(';
        dfs(t, r)
        r += ')'
    }
    
    def dfs(t: TreeNode, r: StringBuilder) {
        if (t== null) return;
        r ++= t.value.toString
        if (t.left != null || t.right != null) {
            dfsc(t.left, r)
            if (t.right != null) dfsc(t.right, r)
        }
    }
}