/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    val INF = 10000
    def findClosestLeaf(root: TreeNode, k: Int): Int = {
        if (root == null) return -1
        find(root, 1, k)._1
    }
    
    def find(node: TreeNode, d: Int, k: Int) : (Int, Int, Int) = {
        if (node == null) return (-1, INF, -1)
        if (node.value == k) {
            val r = closest(node)
            //println(r._1, r._2, d)
            return (r._1, r._2, d)
        }
        if (node.left == null && node.right == null) {
            return (node.value, 1, -1)
        }
        val left = find(node.left, d+1, k)
        val right = find(node.right, d+1, k)
        if (left._3 >= 0) {
            val dr = right._2 + left._3 - d 
            if (dr < left._2) {
                //println(right._1, dr, left._3)
                return (right._1, dr, left._3)
            } else {
                return left
            }
        } else if (right._3 >= 0) {
            val dr = left._2 + right._3 - d
            if (dr < right._2) {
                //println(left._1, dr, right._3)
                return (left._1, dr, right._3)
            } else {
                return right
            }
        } else {
            if (right._2 < left._2) {
                return (right._1, right._2 + 1, -1)
            } else {
                return (left._1, left._2 + 1, -1)
            }
        }
    }
    
    def closest(node: TreeNode) : (Int, Int) = {
        if (node == null) return (-1, INF)
        if (node.left == null && node.right == null) return (node.value, 0)
        val left = closest(node.left)
        val right = closest(node.right)
        //println(node.value, left._2, right._2)
        if (right._2 < left._2) {
            (right._1, right._2 + 1)
        } else {
            (left._1, left._2 + 1)
        }
    }
}