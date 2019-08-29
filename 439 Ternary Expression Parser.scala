object Solution {
    def parseTernary(expression: String): String = {
        var i = 0
        while(i<expression.length) {
            val c = expression(i)
            // observation: if c is the answer, then either the next char is ':' or it's the last char. Otherwise, its a ternary expression.
            if (i == expression.length - 1 || expression(i+1) == ':') return c.toString
            // skip the T? or F?
            // If it's T, the subexpression starts from i+2
            i += 2
            if (c == 'F') {
                // if it's F, we need to skip the subexpression for T.
                // Note the '?' and ':' are paired in the subexpression.
                // So we just skip all paired '?' and ':'. The next unpaired ':' is the beginning of the subexpression for F
                var q = 0
                while (i<expression.length && q >= 0) {
                    if (expression(i)=='?') q += 1
                    else if (expression(i) ==':') q -= 1
                    i+=1
                }
            }
        }
        throw new Exception()
    }
}