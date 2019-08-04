object Solution {
    def shiftingLetters(S: String, shifts: Array[Int]): String = {
        val s = S.toArray
        var shift = 0
        for (i<-S.length -1 to 0 by -1) {
            shift = (shift + shifts(i)) % 26
            s(i) = ((s(i) - 'a' + shift) % 26 + 'a').toChar
        }
        s.mkString
    }
}