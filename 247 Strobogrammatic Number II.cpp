class Solution {
    const char* c1 = "018";
    const char* c21 = "01689";
    const char* c22 = "01986";
    const char* c31 = "1689";
    const char* c32 = "1986";
    int n1 = 3;
    int n2 = 5;
    int n3 = 4;
    
public:
    vector<string> findStrobogrammatic(int n) {
        vector<string> r;
        if (n<=0) return r;
        vector<char> b(n+1);
        b[n] = '\0';
        fill(b.data(), 0, n-1, r);
        return r;
    }
    
    void fill(char* b, int i, int j, vector<string>& r) {
        if (i > j) {
            r.push_back(string(b));
            return;
        }
        if (i==j) {
            for (int k=0; k<n1; ++k) {
                b[i] = c1[k];
                fill(b, i+1, j-1, r);
            }
        } else {
            const char* x = c21;
            const char* y = c22;
            int n = n2;
            if (i == 0) {
                x = c31;
                y = c32;
                n = n3;
            }
            for (int k=0; k<n; ++k) {
                b[i] = x[k]; b[j] = y[k];
                fill(b, i+1, j-1, r);
            }
        }
    }
};