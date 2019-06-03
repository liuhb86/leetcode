import scala.math.max
object Solution {
  def canTransform(start: String, end: String): Boolean = {
    var re = -1
    var xe = -1
    for (i<- 0 until end.length) {
      val c = end(i)
      val cs = if (re > i) 'R' else if (xe > i) 'X' else start(i)
      if (c != cs) {
        if (c=='R') return false
        if (c=='X' && cs == 'R') {
          re = max(re, i + 1)
          while (re<start.length && start(re)=='R') re+=1
          if (re >= start.length || start(re)!='X') return false
          re += 1
        } else if (c=='L' && cs =='X') {
          xe = max(xe, i+1)
          while (xe < start.length && start(xe)=='X') xe+=1
          if (xe >= start.length || start(xe)!='L') return false
          xe += 1
        } else {
          return false
        }
      }
    }
    true
  }
}