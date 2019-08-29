import scala.collection.mutable.StringBuilder
object Solution {
    def expand(S: String): Array[String] = {
        if (S.isEmpty) return Array("")
        if (S.head == '{') {
            val e = S.indexOf('}')
            val t = expand(S.substring(e+1, S.length))
            S.substring(1, e).split(",").sorted.flatMap(c => t.map(c + _))
        } else {
            var i = 0
            while (i<S.length && S(i)!='{') i+=1
            val a = S.substring(0, i)
            expand(S.substring(i, S.length)).map(a + _)
        }
    }
}