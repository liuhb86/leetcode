object Solution {
    def highFive(items: Array[Array[Int]]): Array[Array[Int]] = {
        items.groupBy(_(0)).mapValues(_.toArray.map(_(1)).sortBy(-_).take(5).sum/5)
            .toArray.map(x=> Array(x._1, x._2)).sortBy(_(0))
    }
}