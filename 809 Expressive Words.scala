object Solution {
    def expressiveWords(S: String, words: Array[String]): Int = {
        words.count(x => matches(S, x))
    }
    
    def matches(s:String, w: String) : Boolean = {
        //println(w)
        var i = 0
        var j = 0
        while(i<s.length && j< w.length) {
            if (s(i) != w(j)) return false
            val c = s(i)
            var ni = i + 1
            while (ni < s.length && s(ni)==c) ni += 1
            var nj = j + 1
            while (nj < w.length && w(nj) ==c) nj += 1
            val si = ni -i; val sj = nj-j
            //println(s"$c $si $sj")
            if (si < sj) return false
            if (si > sj && si<3) return false
            i = ni; j = nj    
        }
        i == s.length && j == w.length
    }
}