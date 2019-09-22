import scala.collection.mutable.{Map, ListBuffer}
import scala.collection.BufferedIterator
object Solution {
    def evaluate(expression: String): Int = {
        val tokens = expression
            .replaceAll("\\(", "( ").replaceAll("\\)"," )")
            .split(" +").toIterator.buffered
        val tree = parse(tokens)
        eval(tree, null)
    }
    
    def parse(tokens: BufferedIterator[String]) : Node = {
        val t = tokens.next
        if (t== "(") {
            val lb = ListBuffer[Node]()
            while (tokens.head != ")") lb += parse(tokens)
            tokens.next
            ListNode(lb.result)
        } else if (t.head.isLetter) {
            VarNode(t)
        } else {
            IntNode(t.toInt)
        }
    }
    
    def eval(tree: Node, scope: Scope) : Int = {
        tree match {
            case IntNode(v) => v
            case VarNode(v) => scope.get(v)
            case ListNode(VarNode("add")::v1::v2::Nil) =>
                eval(v1,scope) + eval(v2, scope)
            case ListNode(VarNode("mult")::v1::v2::Nil) =>
                eval(v1,scope) * eval(v2, scope)
            case ListNode(VarNode("let") :: x) =>
                val lscope = new Scope(scope)
                var list = x
                while(list.tail.nonEmpty) {
                    val k = list.head.asInstanceOf[VarNode].v
                    val v = eval(list.tail.head, lscope)
                    lscope.put(k,v)
                    list = list.tail.tail
                }
                eval(list.head, lscope)
        }
    }
}

abstract class Node{}
case class IntNode(v: Int) extends Node
case class VarNode(v: String) extends Node
case class ListNode(list: List[Node]) extends Node

class Scope(p: Scope) {
    def this() = this(null)
    val map = Map[String, Int]()
    def get(k: String) : Int = map.getOrElse(k, p.get(k))
    def put(k: String,v : Int) {map(k) = v}
}