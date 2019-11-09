class Solution {
public:
    vector<int> circularPermutation(int n, int start) {
        vector<int> r0 = rec(n);
        int m = 1 << n;
        int i = 0;
        for (i = 0; i<m; ++i) {
            if (r0[i] == start) break;
        }
        vector<int> result(m);
        int k = 0;
        for (int j=i; j < m; ++j) {
            result[k++] = r0[j];
        }
        for (int j=0; j<i; ++j) {
            result[k++] = r0[j];
        }
        return result;
    }
    
    vector<int> rec(int n) {
        vector<int> result(2<<n);
        if (n == 1) {
            result[0] = 0;
            result[1] = 1;
            return result;
        }
        vector<int> prev = rec(n-1);
        int m = 1 << (n-1);
        for (int i = 0; i < m; ++i) {
            result[i] = prev[i];
        }
        for (int i = 0; i<m; ++i) {
            result[m+i] = prev[m-1-i] | m;
        }
        return result;
    }
};