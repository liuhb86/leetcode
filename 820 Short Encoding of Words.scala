object Solution {
    def minimumLengthEncoding(words: Array[String]): Int = {
        val root = new Node()
        var r = 0
        for (w<-words) {
            var p = root
            var newNode = false
            for (i<- 1 to w.length) {
                val c = w(w.length - i) - 'a'
                if (p(c) == null) {
                    p(c) = new Node()
                    newNode = true
                } else if (p(c).terminal) {
                    p(c).terminal = false
                    r -= (i+1)
                    newNode = true
                }
                p = p(c)
            }
            if (newNode) {
                p.terminal = true
                r += (w.length + 1)
            }
        }
        r
    }
}

class Node {
    var terminal = false
    val children = new Array[Node](26)
    def apply(i: Int) = children(i)
    def update(i:Int, v: Node) {
        children(i) = v
    }
}