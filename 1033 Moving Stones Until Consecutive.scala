object Solution {
    def numMovesStones(_a: Int, _b: Int, _c: Int): Array[Int] = {
        val a = _a.min(_b).min(_c)
        val c = _a.max(_b).max(_c)
        val b = _a + _b + _c - a - c
        var min = 
            if (b-a==1 && c-b ==1) 0
            else if(b-a<=2 || c-b<=2) 1
            else 2
        Array(min, c-a-2)
    }
}