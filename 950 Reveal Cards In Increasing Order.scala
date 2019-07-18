object Solution {
    def deckRevealedIncreasing(deck: Array[Int]): Array[Int] = {
        val sorted = deck.sortBy(-_)
        val r = scala.collection.mutable.ListBuffer[Int]()
        r.append(sorted.head)
        for(c<-sorted.tail) {
            val x = r.last
            r.trimEnd(1)
            r.prepend(x)
            r.prepend(c)
        }
        r.toArray
    }
}