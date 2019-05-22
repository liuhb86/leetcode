object Solution {
    def strWithout3a3b(A: Int, B: Int): String = {
        var a = A
        var b = B
        var last = '_'
        var count = 0
        val sb = new scala.collection.mutable.StringBuilder(A+B)
        while(a>0 || b>0) {
            val next = 
                if (last == 'a' && count == 2) 'b'
                else if (last == 'b' && count ==2) 'a'
                else if (b > a) 'b'
                else 'a'
            sb += next
            if (next == 'a') a-=1 else b-=1
            count = if (last == next) 2 else 1
            last = next
        }
        sb.toString
    }
}