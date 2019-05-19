import scala.collection.mutable.ListBuffer

object Solution {
    def removeDuplicates(S: String): String = {
        val b = new ListBuffer[Char]()
        for (c<- S) {
            if (!b.isEmpty && b.last == c) {
                b.trimEnd(1)
            } else {
                b += c
            }
        }
        b.mkString
    }
}