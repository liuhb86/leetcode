/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def allPossibleFBT(N: Int): List[TreeNode] = {
        if (N % 2 == 0) return Nil
        val trees = Array.fill[List[TreeNode]](N+1)(Nil)
        trees(1) ::= new TreeNode(0)
        for (i <- 3 to N by 2) {
            for (nleft <- 1 to i-2 by 2) {
                val nright = i - nleft - 1
                for (left <- trees(nleft); right<-trees(nright)) {
                    val node = new TreeNode(0)
                    node.left = left
                    node.right = right
                    trees(i) ::= node
                }
            }
        }
        trees(N)
    }
}