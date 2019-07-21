/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def flipMatchVoyage(root: TreeNode, voyage: Array[Int]): List[Int] = {
        dfs(root, voyage, 0, Nil)._2
    }
    
    def dfs(node: TreeNode, voyage: Array[Int], _i: Int, r: List[Int]) : (Int, List[Int]) = {
        var i = _i
        if (node == null) return (i, r)
        if (i >= voyage.length) return (-1, List(-1))
        if (node.value != voyage(i)) return (-1, List(-1))
        i+= 1
        var list = r
        val (left, right) = 
            if (node.left != null && i < voyage.length && node.left.value != voyage(i)) {
                list = node.value :: list
                (node.right, node.left)
            } else {
                (node.left, node.right)
            }
        val rl = dfs(left, voyage, i, list)
        if (rl._1 < 0) return rl
        i = rl._1
        list = rl._2
        dfs(right, voyage, i, list)
    }
}