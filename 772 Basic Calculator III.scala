import scala.collection.mutable.ArrayBuffer
object Solution {
    def calculate(s: String): Int = {
        val ns = ArrayBuffer[Int]()
        val os = ArrayBuffer[Char]()
        var i = 0
        var expectNumber = true
        while (i<s.length) {
            val c= s(i)
            if (c==' ') {
                i+=1
            } else if (c=='(') {
                os += c
                i+=1
            }
            else if (c==')') {
                calc(ns, os, 0)
                if (os.isEmpty || os.last != '(') throw new Exception()
                os.trimEnd(1)
                i+=1
            } else if (!expectNumber && (c=='+' || c=='-' || c=='*' || c=='/')) {
                calc(ns, os, p(c))
                os += c
                i+=1
                expectNumber = true
            } else {
                var n = 0
                var neg = false
                if (s(i)=='-') {
                    neg = true
                    i+=1
                }
                while (i<s.length && s(i).isDigit) {
                    n = n* 10 + (s(i)-'0')
                    i+=1
                }
                if (neg) n = -n
                ns+= n
                expectNumber = false
            }
        }
        calc(ns, os, 0)
        if (os.nonEmpty || ns.length != 1) throw new Exception()
        ns.head
    }
                    
    def p(op: Char) : Int = {
        if (op=='+' || op=='-') return 1
        2
    }
                    
    def calc(ns: ArrayBuffer[Int], os: ArrayBuffer[Char], pri: Int) {
        while (os.nonEmpty && os.last != '(' && p(os.last) >= pri) {
            val op = os.last
            os.trimEnd(1)
            if (ns.length < 2) throw new Exception()
            val n2 = ns.last; ns.trimEnd(1)
            val n1 = ns.last; ns.trimEnd(1)
            val r = op match {
                case '+' => n1+n2
                case '-' => n1-n2
                case '*' => n1*n2
                case '/' => n1/n2
            }
            ns += r
        }
    }
}