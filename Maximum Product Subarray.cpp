class Solution {
public:
    int maxProduct(int A[], int n) {
        if (n<=0) return 0;
        int m = A[0];
        int mpos = 1;
        int mneg = 0;
        for (int i=0;i<n;++i) {
            int k = A[i];
            int p;
            if (k>0) {
                p = mpos*k;
                mpos*=k;
                if (mneg) mneg*=k;
            } else if (k<0) {
                p = (mneg) ? mneg*k : k;
                int t = mneg;
                mneg = mpos*k;
                mpos = t ? t*k : 1;
            } else {
                p = 0;
                mpos = 1;
                mneg = 0;
            }
            if (p>m) m = p;
        }
        
        return m;
    }
};