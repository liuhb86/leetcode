class Solution {
public:
    int minCut(string s) {
        int n = s.size();
        if (n==0) return true;
        vector<vector<bool> > isPal(n+1);
        for (int i=0; i<n;++i) isPal[0].push_back(true);
        for (int i=0; i<n;++i) isPal[1].push_back(true);
        for (int len = 2; len<=n;++len) {
            for (int i=0;i<=n-len;++i) isPal[len].push_back(s[i] == s[i+len-1] ? isPal[len-2][i+1] : false);
        }
        
        vector<int> minC(n+1);
        minC[0]=0;
        for (int len = 1; len<=n;++len) {
            minC[len] = isPal[len][0] ? 0 :n;
            for (int i=1;i<len;++i) {
                if (isPal[len-i][i]) {
                    minC[len] = min(minC[len], minC[i]+1);
                }
            }
        }
        return minC[n];
    }
};