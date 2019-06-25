object Solution {
    val M = 1000000007
    def numDecodings(s: String): Int = {
        var c2 = 1L
        var c1 = s.head match {
            case '*' => 9L
            case '0' => 0L
            case _ => 1L
        }
        for (i<- 1 until s.length) {
            var c = 0L
            val n1 = s(i) match {
                case '*' => 9
                case '0' => 0
                case _ => 1
            }
            c =  (c + c1 * n1) % M
            val n2 = (s(i-1), s(i)) match {
                case ('0', _) => 0
                case ('1', '*') => 9
                case ('1', _) => 1
                case ('2', '*') => 6
                case ('2', t) => if (t<='6') 1 else 0 
                case ('*', '*') => 15
                case ('*', t) => if (t<='6') 2 else 1
                case _ => 0
            }
            c = (c+ c2* n2) % M
            c2=c1
            c1 = c
        }
        c1.toInt
    }
}