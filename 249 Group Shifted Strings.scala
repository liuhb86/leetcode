import scala.collection.mutable.Map
object Solution {
    def groupStrings(strings: Array[String]): List[List[String]] = {
        val map = Map[List[Int], List[String]]()
        for (s<-strings) {
            var olist : List[Int] = Nil
            var last = ' '
            for (c<-s) {
                if (last == ' ') {
                    olist = 0 :: olist
                } else {
                    olist = (c-last + 26) % 26 :: olist
                }
                last = c
            }
            map(olist) = s :: map.getOrElse(olist, Nil)
        }
        map.values.toList
    }
}