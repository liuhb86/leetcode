object Solution {
    val diff = 'a' - 'A'
    def toLowerCase(str: String): String = {
        str.map(c => if (c>='A' && c<='Z') (c + diff).toChar else c)
    }
}