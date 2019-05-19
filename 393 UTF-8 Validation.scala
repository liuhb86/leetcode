object Solution {
    def validUtf8(data: Array[Int]): Boolean = {
        var i = 0
        while (i < data.length) {
            val c = data(i)
            val k = 
                if ((c & 0x80) == 0x00 ) Some(0)
                else if ((c & 0xe0) == 0xc0) Some(1)
                else if ((c & 0xf0) == 0xe0) Some(2)
                else if ((c & 0xf8) == 0xf0) Some(3)
                else None
            if (k.isEmpty) return false
            for (j <- 0 until k.get) {
                i += 1
                if (i == data.length) return false
                val c = data(i)
                if ((c & 0xc0) != 0x80) return false
            }
            i += 1
        }
        true
    }
}