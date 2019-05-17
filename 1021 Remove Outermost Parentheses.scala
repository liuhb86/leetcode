import scala.collection.mutable.StringBuilder
object Solution {
    def removeOuterParentheses(S: String): String = {
        val r = new StringBuilder
        var stack : List[Int] = Nil
        for (i<-0 until S.length) {
            if (S(i) == '(' ) {
                stack = i :: stack
            } else {
                val b = stack.head
                stack = stack.tail
                if (stack == Nil) {
                    r ++= S.substring(b + 1, i)
                }
            }
        }
        r.toString
    }
}