object Solution {
    def largeGroupPositions(S: String): List[List[Int]] = {
        var result : List[List[Int]] = Nil
        var start = 0
        for (i<- 1 to S.length) {
            if (i == S.length || S(i) != S(i-1)) {
                val len = i - start
                if (len >=3) {
                    result = List(start, i -1) :: result
                }
                start = i
            }
        }
        result.reverse
    }
}