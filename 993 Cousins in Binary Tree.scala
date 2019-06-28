/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
        val r = new R()
        search(root, x, y, 0, null, r)
        r.d1==r.d2 && r.p1!= r.p2
    }
    
    def search(node: TreeNode, x: Int, y: Int, d: Int, p: TreeNode, r: R) {
        if (node == null) return
        if (node.value==x) {r.d1 = d; r.p1 = p}
        else if (node.value == y) {r.d2=d;r.p2=p}
        search(node.left, x, y, d+1, node,r)
        search(node.right, x,y,d+1,node,r)
    }
}

class R {
    var d1 = -1
    var d2 = -1
    var p1 : TreeNode = null
    var p2 : TreeNode = null
}