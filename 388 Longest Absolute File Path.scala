import scala.collection.mutable.ListBuffer
object Solution {
    def lengthLongestPath(input: String): Int = {
        val path = new ListBuffer[Node]
        val root = new Node(0, -1, false)
        path += root
        for (s <- input.split("\n")) {
            val len = s.dropWhile(_=='\t').length
            val space = s.length - len
            val node = new Node(len, space, s.contains('.'))
            while (path.last.space>=space) path.trimEnd(1)
            path.last.children += node
            path += node
        }
        val r = longest(root)
        if (r > 0) r -1 else 0
    }
    
    def longest(node: Node) : Int = {
        if (node.isFile) return node.len
        val c = node.children.map(longest).filter(_>0)
        if (c.isEmpty) return -1
        c.max + node.len + 1
    }
}

class Node(val len: Int, val space: Int, val isFile: Boolean) {
    val children = new ListBuffer[Node]()
}