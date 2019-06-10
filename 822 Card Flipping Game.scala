object Solution {
    def flipgame(fronts: Array[Int], backs: Array[Int]): Int = {
        val c = fronts.zip(backs).filter(x => x._1==x._2).map(_._1).toSet
        val f = (fronts ++ backs).filter(x => !c.contains(x))
        if (f.isEmpty) return 0
        f.min
    }
}