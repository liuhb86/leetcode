import scala.collection.mutable.{StringBuilder, ListBuffer}
object Solution {

  var i = 0
  var e = ""
  def braceExpansionII(expression: String): List[String] = {
    i = 0
    e = expression
    eval().sorted
  }

  def eval() : List[String] = {
    val terms = ListBuffer[List[String]]()
    val factors = ListBuffer[List[String]]()
    val s = new StringBuilder()

    def closeString(): Unit = {
      if (s.nonEmpty) {
        factors += List(s.toString)
        s.clear()
      }
    }

    def closeTerm(): Unit = {
      closeString()
      var x = List("")
      for (l <- factors) {
        val t = for(a<-x;b<-l) yield a ++ b
        x = t.distinct
      }
      terms += x
      factors.clear()
    }

    while (i< e.length && e(i) != '}') {
      if (e(i) == '{') {
        closeString()
        i += 1
        val rx = eval()
        factors += rx
      } else if (e(i) == ',') {
        closeTerm()
        i += 1
      } else {
        s += e(i)
        i += 1
      }
    }
    closeTerm()
    i += 1
    terms.toList.flatten.distinct
  }
}