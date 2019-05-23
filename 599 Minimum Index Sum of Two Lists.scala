object Solution {
    def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
        val map = list1.zipWithIndex.toMap
        val common = (list2.zipWithIndex.map{
            case (w, i) =>
                (w, map.get(w).map(_ +i))
        }).filter(_._2.isDefined).map(p => (p._1, p._2.get))
        val min = common.minBy(_._2)._2
        common.filter(_._2 == min).map(_._1)
    }
}