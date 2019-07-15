import scala.collection.Iterator
object Solution {
    def parseBoolExpr(expression: String): Boolean = {
        parse(expression.toIterator)
    }
    
    def parse(expr: Iterator[Char]) : Boolean = {
        val c = expr.next();
        if (c == 't') return true
        if (c == 'f') return false
        var r : Boolean = if (c=='&') true else false
        while(expr.next()!=')') {
            val v = parse(expr)
            if (c=='&') r = r && v
            else if (c=='|') r = r || v
            else r = !v
        }
        r
    }
}