object Solution {
    def generatePalindromes(s: String): List[String] = {
        val d = s.groupBy(identity).mapValues(_.length).toArray
        if (s.length % 2 == 0) {
            if (d.exists(_._2 % 2 == 1)) return Nil
            d.map(x=>x._1.toString * (x._2 / 2)).mkString.permutations
                .map(x=> x + x.reverse).toList
        } else {
            val f = d.filter(_._2 % 2 == 1)
            if (f.length != 1) return Nil
            val c = f.head._1.toString
            d.map(x=>x._1.toString * (x._2 / 2)).mkString.permutations
                .map(x=> x + c + x.reverse).toList
        }
    }
}