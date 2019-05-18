object Solution {
    def countSegments(s: String): Int = {
        val t = s.trim
        if (t.isEmpty) 0
        else t.split(" +").length
    }
}