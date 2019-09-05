class Solution {
public:
    vector<bool> canMakePaliQueries(string s, vector<vector<int>>& queries) {
        vector<vector<int> > c(s.size() + 1);
        c[0].resize(26);
        for (int i=0; i<s.size(); i+=1) {
            c[i+1].resize(26);
            for (int k = 0; k<26; k+=1) c[i+1][k] = c[i][k];
            c[i+1][s[i]-'a'] += 1;
        }
        vector<bool> res(queries.size());
        for (int q = 0; q<queries.size(); q+=1) {
            int l = queries[q][0];
            int r = queries[q][1] + 1;
            int k = queries[q][2];
            int odd = 0;
            for (int i=0; i<26; i+=1) {
                int x = c[r][i] - c[l][i];
                if (x % 2 == 1) odd+=1;
            }
            if ((r-l) % 2 == 0) {
                res[q] = odd <= k * 2;
            } else {
                res[q] = (odd-1) <= k*2;
            }
        }
        return res;
    }

};

