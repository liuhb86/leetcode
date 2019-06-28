object Solution {
    def brokenCalc(X: Int, Y: Int): Int = {
        var r = 0
        var y = Y
        while (y > X) {
            if ( y % 2 == 0) {y/=2; r+=1}
            else {y = y / 2 + 1; r+=2}
        }
        r + X- y
    }
}