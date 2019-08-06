object Solution {
    def numsSameConsecDiff(N: Int, K: Int): Array[Int] = {
        if (N == 1) return (0 to 9).toArray
        if (K==0) {
            var d = 1
            for (i<-2 to N) d = d*10+1
            return (1 to 9).toArray.map(_ * d)
        }
        var r : List[Int] = (1 to 9).toList
        for (i<-2 to N) {
            var rn : List[Int] = Nil
            for (n<-r) {
                val d = n % 10
                if (d+K<10) rn = (n*10+d +K) :: rn
                if (d-K>=0) rn = (n*10+d-K) :: rn
            }
            r = rn
        }
        r.toArray
    }
}