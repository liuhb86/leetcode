import scala.collection.Iterator
object Solution {
  def backspaceCompare(S: String, T: String): Boolean = {
    new It(S).sameElements(new It(T))
  }
}

class It(s: String) extends Iterator[Char] {
  var back = 0
  var index = s.length
  seek()

  def next() : Char = {
    val n = s(index)
    seek()
    n
  }

  def seek() {
    index -= 1
    while (index >= 0) {
      if (s(index) == '#') {
        back += 1
      } else if (back == 0) {
        return
      } else {
        back -= 1
      }
      index -= 1
    }
  }

  def hasNext() : Boolean = {
    index >= 0
  }
}