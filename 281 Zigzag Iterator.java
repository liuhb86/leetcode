public class ZigzagIterator {

    Node p = null;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        Node h = new Node(null);
        p = h;
        Iterator<Integer> it1 = v1.iterator();
        Iterator<Integer> it2 = v2.iterator();
        if (it1.hasNext()) {
            p.next = new Node(it1);
            p = p.next;
        }
        if (it2.hasNext()) {
            p.next = new Node(it2);
            p = p.next;
        }
        if (p != h) {
            p.next = h.next;
        } else {
            p = null;
        }
        
    }

    public int next() {
        int v = p.next.it.next();
        if (!p.next.it.hasNext()) {
            if (p.next == p) {
                p = null;
                return v;
            } else {
                p.next = p.next.next;
            }
        }
        p = p.next;
        return v;
    }

    public boolean hasNext() {
        return p != null;
    }
}

class Node {
    Node next = this;
    Iterator<Integer> it;
    Node(Iterator<Integer> it) {
        this.it = it;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */