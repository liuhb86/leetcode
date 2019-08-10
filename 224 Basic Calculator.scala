import scala.collection.mutable.ArrayBuffer
object Solution {
    def calculate(s: String): Int = {
        val ns = ArrayBuffer[Int]()
        val os = ArrayBuffer[Char]()
        var i = 0
        while (i<s.length) {
            val c= s(i)
            if (c==' ') {
                i+=1
            } else if (c=='(') {
                os += c
                i+=1
            }
            else if (c==')') {
                calc(ns, os)
                if (os.isEmpty || os.last != '(') throw new Exception()
                os.trimEnd(1)
                i+=1
            } else if (c=='+' || c=='-') {
                calc(ns, os)
                os += c
                i+=1
            } else {
                var n = 0
                while (i<s.length && s(i).isDigit) {
                    n = n* 10 + (s(i)-'0')
                    i+=1
                }
                ns+= n
            }
        }
        calc(ns, os)
        if (os.nonEmpty || ns.length != 1) throw new Exception()
        ns.head
    }
                    
    def calc(ns: ArrayBuffer[Int], os: ArrayBuffer[Char]) {
        while (os.nonEmpty && os.last != '(') {
            val op = os.last
            os.trimEnd(1)
            if (ns.length < 2) throw new Exception()
            val n2 = ns.last; ns.trimEnd(1)
            val n1 = ns.last; ns.trimEnd(1)
            val r = if (op =='+') n1+n2 else n1-n2
            ns += r
        }
    }
}