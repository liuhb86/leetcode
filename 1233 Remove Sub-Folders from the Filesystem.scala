import scala.util.control.Breaks._
import scala.collection.mutable.{Map, ListBuffer}
object Solution {
    def removeSubfolders(folder: Array[String]): List[String] = {
        val root = new Node()
        for (f<-folder) {
            val path = f.tail.split("/")
            var node = root
            breakable {for (p<- path){
                if (node.isLeaf) break
                node = node.children.getOrElseUpdate(p, new Node())
            }}
            node.isLeaf = true
        }
        val r = ListBuffer[String]()
        getResult(root, r, "")
        r.result
    }
    
    def getResult(node: Node, r: ListBuffer[String], path: String) {
        if (node.isLeaf) {
            r += path
            return
        }
        for ((f, n) <- node.children) {
            getResult(n, r, path + "/" + f)
        }
    }
}

class Node {
    val children = Map[String, Node]()
    var isLeaf = false
}