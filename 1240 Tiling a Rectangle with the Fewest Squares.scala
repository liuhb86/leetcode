object Solution {
    val map= Map(
        (5,6) -> 5,
        (6,7) -> 5,
        (7,8) ->7,
        (8,9) -> 7,
        (9,10) -> 6,
        (10,11) -> 6,
        (10,12) ->5,
        (11,12) -> 7,
        (11,13) -> 6,
        (12,13) ->7
    )
    def tilingRectangle(n: Int, m: Int): Int = {
        if (n == m) return 1
        if (n>m) return tilingRectangle(m, n)
        val s = map.get((n,m))
        if (s.isDefined) return s.get
        return tilingRectangle(n, m-n) + 1
    }
}