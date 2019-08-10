object Solution {
    def palindromePairs(words: Array[String]): List[List[Int]] = {
        val root = new Node()
        
        for (i<-words.indices) {
            val w = words(i)
            var p = root
            root.words = i :: root.words
            for (c<-w) {
                val x = c-'a'
                if (p.children(x) == null) p.children(x) = new Node()
                p = p.children(x)
                p.words = i :: p.words
            }
            p.terminal = i
        }
        
        var r : List[List[Int]] = Nil
        for (i<-words.indices) {
            val w = words(i)
            var p = root
            var j = w.length - 1
            while (j >= 0 && p != null ) {
                if (p.terminal >= 0) {
                    if (isPal(w, 0, j)) r = List(p.terminal,i) :: r
                }
                val x = w(j) -'a'
                p = p.children(x)
                j -= 1
            }
            if (p!= null) {
                if (p.postPal == null) {
                    p.postPal = p.words.filter(z=> {
                        val f = words(z)
                        isPal(f, w.length, f.length-1)
                    })
                }
                r = p.postPal.filter(_!=i).map(x=>List(x,i)) ++ r
            }
        }
        r
    }
    
    def isPal(s: String, begin: Int, end: Int) : Boolean = {
        var i = begin; var j = end
        while (i < j) {
            if (s(i) != s(j)) return false
            i+=1; j-=1
        }
        true
    }
}

class Node {
    val children = new Array[Node](26)
    var words : List[Int] = Nil
    var terminal = -1
    var postPal : List[Int] = null
}