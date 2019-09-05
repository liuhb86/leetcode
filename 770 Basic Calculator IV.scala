import scala.collection.mutable.{ArrayBuffer, Map}
object Solution {
  def basicCalculatorIV(expression: String, evalvars: Array[String], evalints: Array[Int]): List[String] = {
    var expr = "("+expression+")"
    expr = expr.replaceAll("\\(","( ").replaceAll("\\)"," )")
    val tokens = expr.split(" ")
    val varMap = evalvars.zip(evalints).toMap
    val numStack = ArrayBuffer[Val]()
    val opStack = ArrayBuffer[String]()
    for (t <- tokens) {
      t match {
        case "" =>
        case "(" => opStack += t
        case ")" | "+" | "-" | "*" => calc(numStack, opStack, t)
        case x if x.head.isDigit =>
          numStack += new Val(Map(Nil -> x.toInt))
        case v =>
          if (varMap.contains(v)) {
            numStack += Val(Map(Nil -> varMap(v)))
          } else {
            numStack += Val(Map(List(v) -> 1))
          }
      }
    }
    numStack.head.v.toList
      .filter(_._2 != 0)
      .sortBy(x=> (-x._1.length, x._1.mkString(" ")))
      .map(x=> if (x._1.nonEmpty) x._2.toString+"*"+ x._1.mkString("*")
                else x._2.toString)
  }

  def pr(op: String) = op match {
    case ")" => 0
    case "+" | "-" => 1
    case "*" => 2
    case "(" => -1
  }

  def calc(numStack: ArrayBuffer[Val], opStack: ArrayBuffer[String], op: String) = {
    while (opStack.nonEmpty && pr(opStack.last) >= pr(op)) {
      val oper = opStack.last; opStack.trimEnd(1)
      val n2 = numStack.last; numStack.trimEnd(1)
      val n1 = numStack.last; numStack.trimEnd(1)
      val n = oper match {
        case "+" => add(n1, n2)
        case "-" => add(n1, Val(n2.v.map(x => (x._1, -x._2))))
        case "*" => mul(n1, n2)
      }
      numStack += n
    }
    if (op == ")") opStack.trimEnd(1)
    else opStack += op
  }

  def add(n1: Val, n2: Val) : Val = {
    for ((k,v) <- n2.v) {
      n1.v(k) = n1.v.getOrElse(k, 0) + v
    }
    n1.v.filter(_._2 != 0)
    n1
  }

  def mul(n1: Val, n2: Val) : Val = {
    val m = Map[List[String], Int]()
    for ((k1,v1) <- n1.v; (k2,v2) <- n2.v) {
      val k = (k1 ++ k2).sorted
      m(k) = m.getOrElse(k, 0) + v1 * v2
    }
    m.filter(_._2 != 0)
    Val(m)
  }
}

case class Val(v: Map[List[String], Int])