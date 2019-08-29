class ValidWordAbbr(_dictionary: Array[String]) {

    val s = _dictionary.toSet
    val d = s.groupBy(abbr(_))
    
    def isUnique(word: String): Boolean = {
        val a = abbr(word)
        if (s(word)) d(a).size == 1
        else !d.contains(a)
    }
    
    def abbr(s: String) : String = {
        if (s.length <= 2) s
        else s.substring(0,1) + (s.length - 2).toString + s.substring(s.length -1, s.length)
    }

}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * var obj = new ValidWordAbbr(dictionary)
 * var param_1 = obj.isUnique(word)
 */