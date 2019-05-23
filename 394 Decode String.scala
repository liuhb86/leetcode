import scala.collection.mutable.StringBuilder
object Solution {
    def decodeString(s: String): String = {
        val r = new StringBuilder
        decode(s,0,r)
        r.toString
    }
    
    def decode(s: String, index : Int, result: StringBuilder) : Int = {
        var i = index 
        while (i < s.length) {
            if (s(i).isDigit) {
                val start = i
                while( i < s.length && s(i).isDigit) i += 1
                val repeat = s.substring(start, i).toInt
                val r = new StringBuilder
                i = decode(s, i + 1, r)
                result ++= r.toString * repeat
            } else {
                while (i < s.length && !s(i).isDigit) {
                    if (s(i) == ']') return i + 1
                    result += s(i)
                    i+= 1
                }
            }
        }
        i
    }
}