/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int c = 0;
        for (int i= 1; i < n; i+=1) {
            if (!knows(i, c)) {
                c = i;
            }
        }
        for (int i = 0; i < c; i+=1) {
            if (!knows(i, c)) return -1;
        }
        for (int i = 0; i < n; i+=1) {
            if (i!= c && knows(c, i)) return -1;
        }
        return c;
    }
}