// peek
/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */



class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        int n = 0;
        ImmutableListNode p = head;
        while(p != null) {
            n += 1;
            p = p.getNext();
        }
        int bucketSize = (int)Math.ceil(Math.sqrt(n));
        int c = 0;
        List<ImmutableListNode> buckets = new ArrayList<>();
        p = head;
        while (p != null) {
            if (c==0) {
                buckets.add(p);
            }
            p = p.getNext();
            c += 1;
            if (c== bucketSize) c = 0;
        }
        Collections.reverse(buckets);
        for (ImmutableListNode h: buckets) {
            List<ImmutableListNode> buffer = new ArrayList<>();
            c = 0;
            p = h;
            while (p != null && c < bucketSize) {
                buffer.add(p);
                p = p.getNext();
                c += 1;
            }
            Collections.reverse(buffer);
            for (ImmutableListNode x: buffer) {
                x.printValue();
            }
        }
    }

}