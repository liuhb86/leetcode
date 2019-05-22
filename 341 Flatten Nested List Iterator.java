/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.*;
public class NestedIterator implements Iterator<Integer> {
    
    int nextInt;
    LinkedList<Iterator<NestedInteger>> stack = new LinkedList<>();
    
    void seek() {
        while(!stack.isEmpty()) {
            if (!stack.getLast().hasNext()) {
                stack.removeLast();
                continue;
            }
            NestedInteger n = stack.getLast().next();
            if (n.isInteger()) {
                nextInt = n.getInteger();
                return;
            }
            stack.addLast(n.getList().iterator());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.addLast(nestedList.iterator());
        seek();
    }

    @Override
    public Integer next() {
        int n = nextInt;
        seek();
        return n;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */