object Solution {
    def numberOfLines(widths: Array[Int], S: String): Array[Int] = {
        if (S.isEmpty) return Array(0,0)
        var line = 1
        var w = 0
        for (c <- S) {
            val cw = widths(c-'a')
            w += cw
            if (w > 100) {
                line += 1
                w = cw
            }
        }
        Array(line, w)
    }
}