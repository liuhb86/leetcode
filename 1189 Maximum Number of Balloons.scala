object Solution {
    def maxNumberOfBalloons(text: String): Int = {
        val g = text.groupBy(identity).mapValues(_.length)
        Array(g.getOrElse('b', 0),
              g.getOrElse('a', 0),
              g.getOrElse('l', 0)/2,
              g.getOrElse('o', 0)/2,
              g.getOrElse('n', 0)).min
    }
}