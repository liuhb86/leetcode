/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n==0) return 0;
        char[] buf4 = new char[4];
        int p = 0;
        int n4 = 4;
        while (p < n && n4 == 4) {
            n4 = read4(buf4);
            int k = p + n4;
            if (k > n) k = n;
            int i = 0;
            while (p < k) {
                buf[p] = buf4[i];
                p += 1;
                i += 1;
            } 
        }
        return p;
    }
}