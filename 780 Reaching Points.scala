object Solution {
    def reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean = {
        var x = tx
        var y = ty
        while (x > 0 && y>0) {
            if (x==sx && y == sy) return true
            if (x> y) x-=y
            else y-=x
        }
        false
    }
}