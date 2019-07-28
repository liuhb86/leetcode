object Solution {
    val codes = Array(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
    def uniqueMorseRepresentations(words: Array[String]): Int = {
        words.map(_.map(c=> codes(c-'a')).mkString).toSet.size
    }
}