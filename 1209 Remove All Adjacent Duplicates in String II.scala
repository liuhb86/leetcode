import scala.collection.mutable.{ArrayBuffer, StringBuilder}
object Solution {
    def removeDuplicates(s: String, k: Int): String = {
        val cs = ArrayBuffer[Char]()
        val ns = ArrayBuffer[Int]()
        for (c<-s) {
            if (cs.nonEmpty && cs.last == c) {
                val x = ns.last
                if (x != k - 1) {
                    ns(ns.length -1) = x + 1
                } else {
                    cs.trimEnd(1)
                    ns.trimEnd(1)
                }
            } else {
                cs += c
                ns += 1
            }
        }
        val r = new StringBuilder()
        for (i<-cs.indices) {
            val c = cs(i)
            for (j<- 1 to ns(i)) r += c
        }
        r.toString
    }
}