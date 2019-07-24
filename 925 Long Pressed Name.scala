object Solution {
    def isLongPressedName(name: String, typed: String): Boolean = {
        var c = '\0'
        var i = 0
        for (j <- 0 until typed.length) {
            if (i < name.length && name(i) == typed(j)) {
                i += 1
            } else {
                if (typed(j) != c) return false
            }
            c = typed(j)
        }
        i == name.length
    }
}