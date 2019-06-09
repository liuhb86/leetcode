object Solution {
    def findOcurrences(text: String, first: String, second: String): Array[String] = {
        val s = text.split(" ")
        val r = scala.collection.mutable.ArrayBuffer[String]()
        for (i<-2 until s.length) {
            if (s(i-2)==first && s(i-1)==second) r+=s(i)
        }
        r.toArray
    }
}