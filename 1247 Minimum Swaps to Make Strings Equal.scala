object Solution {
    def minimumSwap(s1: String, s2: String): Int = {
        var xy = 0
        var yx = 0
        for (i<- s1.indices) {
            if (s1(i) == 'x' && s2(i) == 'y') xy += 1
            else if (s1(i) == 'y' && s2(i) == 'x') yx += 1
        }
        if (xy % 2 == 0 && yx %2 == 0) {
            xy/2 + yx/2
        } else if (xy % 2 == 1 && yx % 2 == 1) {
            xy/2+yx/2+2
        } else {
            -1
        }
    }
}