class Solution {
public:
    inline int at(int* A, int i,int j, int n) {
        if (i<0) return j+1;
        if (j<0) return i+1;
        return A[i*n+j];
    }
    int minDistance(string word1, string word2) {
        int m = word1.size();
        int n = word2.size();
        int* d = new int[m*n];
        for (int i=0;i<m;++i) {
            for (int j=0;j<n;++j) {
                int t = at(d,i-1,j-1,n);
                if (word1[i]!=word2[j]) {
                    t = min(t, at(d,i-1,j,n));
                    t = min(t, at(d,i,j-1,n));
                    ++t;
                }
                d[i*n+j] = t;
            }
        }
        int t = at(d,m-1,n-1,n);
        delete d;
        return t;
    }
};
