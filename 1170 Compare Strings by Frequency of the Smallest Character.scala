object Solution {
    def numSmallerByFrequency(queries: Array[String], words: Array[String]): Array[Int] = {
        val c = new Array[Int](12)
        for (w<-words) {
            c(f(w)) += 1
        }
        for (i<-9 to 1 by -1) c(i) += c(i+1)
        queries.map(q=> c(f(q) + 1))
    }
    
    def f(s: String) : Int = {
        val c = s.min
        s.count(_ == c)
    }
}