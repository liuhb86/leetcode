/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def minDiffInBST(root: TreeNode): Int = {
        diff(root)._3.get
    }
    
    def diff(root: TreeNode) : (Int, Int, Option[Int]) = {
        var min = root.value
        var max = root.value
        var r: Option[Int] = None
        if (root.left != null) {
            val v = diff(root.left)
            min = v._1
            r = Some(root.value - v._2)
            if (v._3.isDefined) r = Some(r.get.min(v._3.get))
        }
        if (root.right != null) {
            val v = diff(root.right)
            max = v._2
            r = Some(Array(
                r,
                Some(v._1 - root.value),
                v._3).flatten.min)
        }
        (min, max, r)
    }
}