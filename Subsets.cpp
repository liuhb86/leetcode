class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
        vector<vector<int> > result;
        sort(S.begin(), S.end());
        for (int k=0;k<=S.size();++k) {
            vector<int> pos(k);
            for(int i=0;i<k;++i) pos[i] = i;
            while(true) {
                result.push_back(vector<int>(k));
                for (int u=0;u<k;++u) result.back()[u] = S[pos[u]];
                int i;
                int m = S.size();
                for (i=k-1;i>=0;--i) if (pos[i]!=(--m)) break;
                if (i<0) break;
                int t=pos[i];
                for(int u=i;u<k;++u) pos[u] = ++t;
            }
        }
        return result;
    }
};
