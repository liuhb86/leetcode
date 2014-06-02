class Solution {
public:
    vector<vector<int> > combine(int n, int k) {
        vector<vector<int> > result;
        vector<int> v(k);
        for (int i=0;i<k;++i) v[i]=i+1;
        while(true) {
            result.push_back(v);
            int i,j;
            for (i=k-1,j=0;i>=0;--i,++j) {if (v[i] != n - j) break;}
            if (i<0) break;
            int t = v[i] + 1;
            for (int u=0; u<=j;++u) v[i+u] = t + u;
        }
        return result;
    }
};
