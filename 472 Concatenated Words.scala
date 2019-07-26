import scala.util.control.Breaks._
object Solution {
    def findAllConcatenatedWordsInADict(words: Array[String]): List[String] = {
        val sorted = words.sortBy(_.length).filter(_.nonEmpty)
        var r : List[String] = Nil
        val root = new Node()
        for (word <- sorted) {
            var list = List(root)
            breakable { for (c<- word) {
                var terminal = false
                var next : List[Node] = Nil
                if (list.isEmpty) break
                for (x<- list) {
                    val n = x.get(c)
                    if (n != null) {
                        next = n :: next
                        terminal = terminal || n.terminal
                    }
                }
                list = next
                if (terminal) {
                    list = root :: list
                }
            }}
            if (list.nonEmpty && list.head == root) {
                r = word :: r
            } else {
                var p = root
                for (c<-word) p = p.getOrCreate(c)
                p.terminal = true
            }
        }
        r
    }
}

class Node() {
    var terminal = false
    val children = new Array[Node](26)
    def get(c: Char) : Node = children(c-'a')
    def getOrCreate(c: Char) : Node = {
        if (get(c) != null) return get(c)
        val n = new Node()
        children(c-'a') = n
        n
    }
}