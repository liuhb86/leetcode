import scala.collection.mutable.StringBuilder
object Solution {
    def maskPII(S: String): String = {
        val iat = S.indexOf('@')
        if (iat > 0) {
            val f = S.take(iat)
            val sb = new StringBuilder
            sb += f.head
            sb ++= "*****"
            sb += f.last
            sb ++= S.drop(iat)
            sb.toString.toLowerCase
        } else {
            var n = S.filter(_.isDigit)
            val sb = new StringBuilder
            if (n.length > 10) {
                sb += '+'
                sb ++= "*" * (n.length - 10)
                sb +='-'
            }
            sb ++= "***-***-"
            sb ++= n.takeRight(4)
            sb.toString
        }
    }
}