object Solution {
    def removeKdigits(num: String, k: Int): String = {
        var toRemove = k
        val result = new Array[Char](num.length)
        var i = 0
        var j = -1
        while(i < num.length) {
            if (toRemove > 0 && j >= 0 && num(i) < result(j)) {
                j -= 1
                toRemove -= 1
            } else {
                j += 1
                result(j) = num(i)
                i += 1
            }
        }
        val trimmed = result.take(num.length - k).dropWhile(_ == '0')
        if (trimmed.isEmpty) "0" else trimmed.mkString
    }
}