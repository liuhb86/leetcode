/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *
 *   // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *   def isInteger: Boolean = {}
 *
 *   // Return the single integer that this NestedInteger holds, if it holds a single integer
 *   def getInteger: Int = {}
 *
 *   // Set this NestedInteger to hold a single integer.
 *   def setInteger(i: Int) = {}
 *
 *   // Return the nested list that this NestedInteger holds, if it holds a nested list
 *   def getList = {}
 *
 *   // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *   def add(ni: NestedInteger) = {}
 * }
 */
object Solution {
    def deserialize(s: String): NestedInteger = {
        val iterator = s.toIterator.buffered
        parse(iterator)
    }
    
    def parse(iterator: BufferedIterator[Char]) : NestedInteger = {
        val result = new NestedInteger
        if (iterator.head == '[') {
            iterator.next()
            while(iterator.head != ']') {
                val item = parse(iterator)
                result.add(item)
                if (iterator.head == ',') iterator.next()
            }
            iterator.next()
        } else {
            val sb = new StringBuilder
            while(iterator.hasNext && 
                  (iterator.head == '-' || iterator.head.isDigit)) {
                sb += iterator.next()
            }
            result.setInteger(sb.toInt)
        }
        result
    }
}