import scala.collection.mutable.ArrayBuffer
object Solution {
    def minDeletionSize(A: Array[String]): Int = {
        if (A.length < 2) return 0
        var list = ArrayBuffer(ArrayBuffer(A:_*))
        var r = 0
        for (i<-A.head.indices) {
            if (list.isEmpty) return r
            if (list.exists(x=>needRemove(x, i))) {
                r += 1
            } else {
                val next = ArrayBuffer[ArrayBuffer[String]]()
                for (cg <- list) {
                    var g = ArrayBuffer(cg.head)
                    for (j<- 1 until cg.length) {
                        val s = cg(j)
                        if (s(i)!=g.head(i)) {
                            if (g.length > 1) next += g
                            g = ArrayBuffer(s)
                        } else {
                            g += s
                        }
                    }
                    if (g.length > 1) next += g
                }
                list = next
            }
        }
        r
    }

    
    def needRemove(list: ArrayBuffer[String], i: Int) : Boolean = {
        var last = list.head(i)
        for (j<- 1 until list.length) {
            if (list(j)(i)<last) return true
            last = list(j)(i)
        }
        false
    }
    
}