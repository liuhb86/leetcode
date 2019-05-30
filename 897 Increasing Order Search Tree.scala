/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
 object Solution {
   def increasingBST(root: TreeNode): TreeNode = {
     val d = new TreeNode(0)
     build(root, d)
     d.right
   }

   def build(root: TreeNode, r: TreeNode) : TreeNode = {
     if (root == null) return r
     val p = build(root.left, r)
     p.right = root
     root.left = null
     build(root.right, root)
   }
 }