/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.ListBuffer
object Solution {
    def boundaryOfBinaryTree(root: TreeNode): List[Int] = {
        if (root == null) return List()
        if (root.left == null && root.right == null) return List(root.value)
        lb(root) ++ leaf(root) ++ rb(root)
    }
    
    def lb(root: TreeNode) : List[Int] = {
        if (root.left == null) return List(root.value)
        val b = ListBuffer[Int]()
        lb(root, b)
        b.result
    }
    
    def lb(node: TreeNode, b : ListBuffer[Int]) {
        if (node.left == null && node.right == null) return
        b += node.value
        if (node.left != null) lb(node.left, b)
        else lb(node.right, b)
    }
    
    def leaf(root: TreeNode) : List[Int] = {
        val b = ListBuffer[Int]()
        leaf(root, b)
        b.result
    }
    
    def leaf(node: TreeNode, b: ListBuffer[Int]) {
        if (node == null) return
        if (node.left == null && node.right == null) {
            b += node.value
        } else {
            leaf(node.left, b)
            leaf(node.right, b)
        }
    }
    
    def rb(root: TreeNode) : List[Int] = {
        if (root.right == null) return Nil
        rb(root.right, Nil)
    }
    
    def rb(node: TreeNode, r: List[Int]) : List[Int] = {
        if (node.left == null && node.right == null) return r
        val rr = node.value :: r
        if (node.right != null) rb(node.right, rr)
        else rb(node.left, rr)
    }
}