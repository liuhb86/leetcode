object Solution {
    val digits = Array(
        (0,"zero",'z'),
        (2,"two", 'w'),
        (6,"six",'x'),
        (8,"eight",'g'),
        (3,"three", 'h'),
        (4,"four", 'u'),
        (1,"one", 'o'),
        (5,"five", 'f'),
        (7,"seven", 'v'),
        (9,"nine", 'i'))
    
    def originalDigits(s: String): String = {
        val chars = new Array[Int](26)
        for (c <- s) {
            chars(c-'a') += 1
        }
        val count = new Array[Int](10)
        for ((d, w, c) <- digits) {
            val n = chars(c-'a')
            count(d) = n
            for (x <- w) {
                chars(x-'a') -= n
            }
        }
        count.zipWithIndex.filter(_._1 > 0).map(c => c._2.toString * c._1).mkString
    }
}