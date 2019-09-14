object Solution {
    def countLetters(S: String): Int = {
        var r = 0
        var p = ' '
        var s = 0
        for (c<-S) {
            if (c!=p) {
                r += (1 + s) * s / 2
                p = c
                s = 1
            } else {
                s += 1
            }
        }
        r += (1 + s) * s / 2
        r
    }
}