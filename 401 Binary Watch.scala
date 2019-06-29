object Solution {
    val ph = Array.fill[List[String]](5)(Nil)
    val pm = Array.fill[List[String]](7)(Nil)
    for (i<-11 to 0 by -1) {
        val c = Integer.bitCount(i)
        ph(c) = i.toString :: ph(c)
    }
    for (i<-59 to 0 by -1) {
        val c = Integer.bitCount(i)
        pm(c) = f"$i%02d" :: pm(c)
    }
    def readBinaryWatch(num: Int): List[String] = {
        (for (i<-0.max(num-6) to num.min(3);
            h<-ph(i); m<-pm(num-i)) yield s"$h:$m"
         ).toList
    }
}