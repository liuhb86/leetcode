import scala.util.matching.Regex
object Solution {
    def solveEquation(equation: String): String = {
        var coefficient = 0
        var value = 0
        var factor = 1
        var s : CharSequence = equation
        while (s.length > 0) {
            if (s.charAt(0) == '=' ) {
                factor = -1
                s = s.subSequence(1, s.length)
            } else {
                val m = raw"([+-]?\d*)(x?)".r.findPrefixMatchOf(s).get
                val sv = m.group(1)
                val v = 
                    if (sv.isEmpty || sv == "+") 1
                    else if (sv == "-") -1
                    else m.group(1).toInt
                if (m.group(2).isEmpty) {
                    value += v * factor
                } else {
                    coefficient += v * factor
                }
                s = m.after
            }
        }
        if (coefficient == 0) {
            if (value == 0) {
                "Infinite solutions"
            } else {
                "No solution"
            }
        } else {
            s"x=${-value/coefficient}"
        }
    }
}