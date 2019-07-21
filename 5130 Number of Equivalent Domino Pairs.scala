object Solution {
    def numEquivDominoPairs(dominoes: Array[Array[Int]]): Int = {
        dominoes.map(x => if (x(0) < x(1)) (x(0), x(1)) else (x(1), x(0)) )
            .groupBy(identity).toArray.map(_._2.length)
            .map(x=> if (x==1) 0 else x * (x-1)/2).sum
    }
}