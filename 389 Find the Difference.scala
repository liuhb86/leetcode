object Solution {
    def findTheDifference(s: String, t: String): Char = {
        val f = new Array[Int](26)
        for (c<-s) f(c-'a') += 1
        for (c<-t) {
            if (f(c-'a') == 0) return c
            f(c-'a') -= 1
        }
        throw new Exception()
    }
}