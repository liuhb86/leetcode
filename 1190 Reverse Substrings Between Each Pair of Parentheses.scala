import scala.collection.mutable.Map
object Solution {
    def reverseParentheses(s: String): String = {
        val map = Map[Int, Int]()
        val len = p(s, 0, map)._1
        //println(len)
        val r = new Array[Char](len)
        reverse(s, 0, 0, 1, map, r)
        r.mkString
    }
    
    def reverse(s: String, _i: Int, _j: Int, d: Int, map: Map[Int, Int], r: Array[Char]) : Int = {
        var i = _i
        var j = _j
        while (i<s.length && s(i) != ')') {
            //println(i,j)
            if (s(i) != '(') {
                r(j) = s(i);
                i += 1; j +=d
            } else {
                val len = map(i)
                val j1 = j + (len - 1) * d
                val i1 = reverse(s, i+1, j1, -d, map, r)
                j = j1 + d
                i = i1 + 1
            }
        }
        i
    }
    
    def p(s: String, _i: Int, map: Map[Int, Int]) : (Int, Int) = {
        var len = 0
        var i = _i
        while (i<s.length && s(i) != ')') {
            if (s(i)!= '(') {
                i += 1; len +=1;
            } else {
                val (len1, i1) = p(s, i+1, map)
                map(i) = len1
                len += len1
                i = i1 + 1
            }
        }
        (len, i)
    }

    /* o(n^2)
    def reverseParentheses(s: String): String = {
        r(s, 0)._1
    }
    
    def r(s: String, _i: Int) : (String, Int) = {
        var i = _i
        val sb = new scala.collection.mutable.StringBuilder()
        while (i<s.length && s(i) != ')') {
            if (s(i) != '(') {
                sb += s(i)
                i += 1
            } else {
                val (x, j) = r(s, i+1)
                sb ++= x.reverse
                i = j + 1
            }
        }
        (sb.toString, i)
    }
    */
}