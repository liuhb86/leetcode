object Solution {
    def canConvert(str1: String, str2: String): Boolean = {
        var needTrans = false
        val map = scala.collection.mutable.Map[Char, Char]()
        for (i<-str1.indices) {
            if (str1(i) != str2(i)) {
                val c1 = str1(i); val c2 = str2(i)
                needTrans = true
                val m = map.get(c1)
                if (m.isDefined) {
                    if (m.get != c2) return false
                } else {
                    map(c1) = c2
                }
            }
        }
        if (!needTrans) return true
        str2.distinct.size < 26
    }
}