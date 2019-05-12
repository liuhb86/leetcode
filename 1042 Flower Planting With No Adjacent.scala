//https://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/
object Solution {
    def gardenNoAdj(N: Int, paths: Array[Array[Int]]): Array[Int] = {
        val flowers = (1 to 4).toSet
        val g = paths
            .flatMap(e => Array((e(0), e(1)), (e(1), e(0))))
            .groupBy(_._1).mapValues(_.map(_._2).toSet)
        val answer = new Array[Int](N)
        for (i<- 1 to N) {
            val neighborFlowers =  g.getOrElse(i, Set()).map(n => if (n < i) answer(n - 1) else 0)
            answer(i -1) = (flowers diff neighborFlowers).head
        }
        answer
    }
}