/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    
    char[] buf4 = new char[4];
    int n4 = 0;
    int i = 0;
    boolean eof = false;
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
       if (n==0) return 0;
        int p = 0;
        while (i < n4 && p < n) {
            buf[p] = buf4[i];
            p += 1;
            i += 1;
        }
        while (p < n && !eof) {
            n4 = read4(buf4);
            eof = n4 < 4;
            i = 0;
            while (i < n4 && p < n) {
                buf[p] = buf4[i];
                p += 1;
                i += 1;
            } 
        }
        return p;        
    }
}