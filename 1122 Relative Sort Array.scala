object Solution {
    def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
        val map = arr2.zipWithIndex.map(x => x._1 -> (x._2, x._1)).toMap
        arr1.map(x => map.getOrElse(x, (arr2.length, x))).sorted.map(_._2)
    }
}