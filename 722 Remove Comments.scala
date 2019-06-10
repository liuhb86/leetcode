object Solution {
    def removeComments(source: Array[String]): List[String] = {
        var inBlock: Boolean = false
        var buffer : String  = ""
        var result : List[String] = Nil
        for (line<-source) {
            var r = line
            while (r.nonEmpty) {
                if(inBlock) {
                    val close = r.indexOf("*/")
                    if (close>=0) {
                        r = r.drop(close+2)
                        inBlock = false
                    } else {
                        r = ""
                    }
                } else {
                    var lineComment = r.indexOf("//")
                    if (lineComment < 0) lineComment = r.length
                    var open = r.indexOf("/*")
                    if (open < 0) open = r.length
                    if (lineComment < r.length && lineComment < open) {
                        buffer += r.take(lineComment)
                        r = ""
                    } else if (open < r.length && open < lineComment) {
                        buffer += r.take(open)
                        r = r.drop(open+2)
                        inBlock = true
                    } else {
                        buffer += r
                        r = ""
                    }
                }
            }
            if (!inBlock && buffer.nonEmpty) {
                result = buffer :: result
                buffer = ""
            }
        }
        result.reverse
    }
}