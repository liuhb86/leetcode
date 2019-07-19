object Solution {
    def scoreOfParentheses(S: String): Int = {
        val t = scala.collection.mutable.ArrayBuffer[Int]()
        t += 0
        for (c<-S) {
            if (c=='(') {
                t += 0
            } else {
                val v = if (t.last == 0) 1 else t.last * 2
                t.trimEnd(1)
                t(t.length - 1) += v
            }
        }
        t.head
    }
}