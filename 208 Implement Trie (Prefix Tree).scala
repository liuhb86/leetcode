class Trie() {

    /** Initialize your data structure here. */
    val root = new Node()

    /** Inserts a word into the trie. */
    def insert(word: String) {
        var x = root
        for (c<- word) {
            x = x.getOrCreate(c)
        }
        x.leaf = true
    }

    /** Returns if the word is in the trie. */
    def search(word: String): Boolean = {
        var x = root
        for (c<-word) {
            x = x.get(c)
            if (x== null) return false
        }
        x.leaf
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    def startsWith(prefix: String): Boolean = {
        var x = root
        for (c<-prefix) {
            x = x.get(c)
            if (x==null) return false
        }
        true
    }
    
    class Node {
        val children = new Array[Node](26)
        var leaf = false
        def get(c: Char) : Node = children(c-'a')
        def getOrCreate(c: Char) : Node = {
            val i = c - 'a'
            if (children(i) != null) return children(i)
            val node = new Node()
            children(i) = node
            node
        }
    }

}


/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */