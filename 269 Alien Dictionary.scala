import scala.collection.mutable.{Set, StringBuilder}
object Solution {
    def alienOrder(words: Array[String]): String = {
        if (words.isEmpty) return ""
        val letters = (0 until 26).map(x=>new Letter(('a'+x).toChar)).toArray
        val ls = Set[Letter]()
        for (c<-words.head) ls += letters(c-'a')
        for (k<-1 until words.length) {
            val w1 = words(k-1)
            val w2 = words(k)
            for (c<-w2) ls += letters(c-'a')
            var i = 0; var j = 0
            while (i<w1.length && j<w2.length && w1(i)==w2(j)) {
                i+=1; j+=1
            }
            if (j==w2.length && i < w1.length) return ""
            if (i<w1.length && j<w2.length) {
                val c1 = letters(w1(i)-'a'); val c2 = letters(w2(j)-'a')
                c1.next += c2
                c2.prev += c1
            }
        }
        
        val r = new StringBuilder()
        var list =  ls.toList.filter(_.prev.isEmpty)
        while (list.nonEmpty) {
            var next : List[Letter] = Nil
            for (c<-list) {
                r += c.c
                for(n<-c.next) {
                    n.prev -= c
                    if (n.prev.isEmpty) next = n :: next
                }
            }
            list = next
        }
        if (r.size == ls.size) r.toString else ""
    }
}

class Letter(val c: Char) {
    val prev = Set[Letter]()
    val next = Set[Letter]()
}