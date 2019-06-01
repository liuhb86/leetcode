
import scala.math.{min,max}
object Solution {
  def removeInvalidParentheses(s: String): List[String] = {
    //println(s)
    val toRemove = calcToRemove(s)
    val r = remove(s, 0, 0, toRemove)
    val toRemoveL = calcToRemove(reverse(s))
    if (toRemoveL == 0) {
      r
    } else {
      r.flatMap(t => remove(reverse(t), 0, 0, toRemoveL))
        .map(reverse)
    }
  }

  def reverse(s: String): String = {
    s.reverse.map{
      case '(' => ')'
      case ')' => '('
      case x => x
    }
  }

  def calcToRemove(s: String) : Int = {
    var r = 0
    var l = 0
    for (c <- s) {
      if (c == '(') l += 1
      else if (c==')') {
        if (l >0) l-=1
        else r +=1
      }
    }
    r
  }

  def remove(s: String, start: Int, _left: Int, toRemove: Int) : List[String] = {
    if (toRemove == 0) {
      return List(s.substring(start, s.length))
    }
    var left = _left
    var i = start
    var j = 0
    while (j == 0) {
      val c= s(i)
      if (c ==')') {
        j = i
        while(j<s.length && s(j) ==')') j += 1
      } else {
        if (c == '(') {
          left += 1
        }
        i += 1
      }
    }
    var k = j - i
    (max(0, k-left) to min(k, toRemove))
      .toList.flatMap( x=>
      remove(s,j, left + x -k, toRemove -x)
        .map(t => s.substring(start, j - x) + t))
  }
}