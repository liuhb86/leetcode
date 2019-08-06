/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.ArrayBuffer
object Solution {
    def smallestFromLeaf(root: TreeNode): String = {
        val suffix = new ArrayBuffer[Int]()
        find(root, suffix).toArray.map(x=> (x + 'a').toChar).mkString
    }
    
    def find(n: TreeNode, suffix: ArrayBuffer[Int]) : ArrayBuffer[Int] = {
        if (n==null) return null
        if (n.left == null && n.right == null) return ArrayBuffer(n.value)
        suffix += n.value
        val left = new It(find(n.left, suffix), suffix)
        val right = new It(find(n.right, suffix), suffix)
        val r = if (comp(left, right)) left.s else right.s
        r += n.value
        suffix.trimEnd(1)
        r
    }
    
    def comp(a: It, b: It) : Boolean = {
        if (a.s == null) return false
        if (b.s == null) return true
        while (a.hasNext() && b.hasNext) {
            val aa = a.next()
            val bb = b.next()
            if (aa < bb) return true
            if (aa > bb) return false
        }
        return b.hasNext()
    }
}

class It(val s: ArrayBuffer[Int], p: ArrayBuffer[Int]) {
    var i = 0 
    var d = 1
    var b = s
    def hasNext() : Boolean = {
        if (b==p) return i>=0
        i < s.length || p.nonEmpty
    }
    def next() : Int = {
        if (i == b.length) { b = p; i = b.length -1; d = -1}
        val v = b(i)
        i += d
        v
    }
}
                                           
                                           