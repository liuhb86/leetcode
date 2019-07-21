/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
class CBTInserter(_root: TreeNode) {
    
    var path = findNext(_root, 0, 0, Nil)._1
    
    def findNext(node: TreeNode, d: Int, md: Int, p: List[TreeNode]) : (List[TreeNode],Int) = {
        if (node == null) return (Nil, md)
        var np = node :: p
        var nd = md.max(d)
        if (node.left != null && node.right== null) return (np, md)
        if (node.left == null && node.right == null && d!=nd) return (np,md)
        val ln = findNext(node.left, d+1, nd, np)
        if (ln._1 != Nil) return ln
        val rn = findNext(node.right, d+1, ln._2, np)
        if (rn._1 != Nil) return rn
        if (d != 0) return (Nil, rn._2)
        (leftMostPath(node), md)
    }
    
    def leftMostPath(node: TreeNode) : List[TreeNode] = {
        var lp = node
        var np = List(node)
        while(lp.left != null) {
            lp = lp.left
            np = lp::np
        }
        np
    }
    
    def moveNext() {
        if (path.head.right == null) return
        var p = path.head
        var t = path.tail
        while (t != Nil && p==t.head.right) {
            p = t.head
            t = t.tail
        }
        if (t== Nil) path = leftMostPath(_root)
        else path = leftMostPath(t.head.right) ++ t
    }

    def insert(v: Int): Int = {
        moveNext();
        val next = path.head
        val node = new TreeNode(v)
        if (next.left == null) {
            next.left = node
        } else {
            next.right = node
        }
        return next.value
    }

    def get_root(): TreeNode = {
        _root
    }

}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * var obj = new CBTInserter(root)
 * var param_1 = obj.insert(v)
 * var param_2 = obj.get_root()
 */