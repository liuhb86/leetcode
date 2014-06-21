class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        if (n==0) return 0;
        int w2 = 1;
        int d1 = atoi(s, n-1, 1);
        int d2;
        int w1 = (d1 == 0) ? 0 : 1;
        for (int i=n-2;i>=0;--i) {
            int w;
            d1 = atoi(s, i, 1);
            d2 = atoi(s, i, 2);
            if (d1==0) {
                w = 0;
            } else if (d2>26) {
                w = w1;
            } else {
                w = w1 + w2;
            }
            w2 = w1;
            w1 = w;
        }
        return w1;
    }
    
    int atoi(string& s, int start, int len) {
        if (len==2) {
            return (s[start]-'0')*10+(s[start+1]-'0'); 
        }
        return s[start]-'0';
    }
};