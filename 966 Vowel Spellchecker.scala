object Solution {
    def spellchecker(wordlist: Array[String], queries: Array[String]): Array[String] = {
        val wordSet = wordlist.toSet
        val capMap = wordlist.reverse.map(s => (s.toLowerCase, s)).toMap
        val vowelMap = wordlist.reverse.map( s => (s.toLowerCase.replaceAll("[aeiou]", "_"), s)).toMap
        queries.map(s => 
                    if (wordSet.contains(s)) s 
                    else capMap.getOrElse(s.toLowerCase, vowelMap.getOrElse(s.toLowerCase.replaceAll("[aeiou]", "_"), "")))
    }
}