class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
        map<int, int> count;
        for (int i=0;i<S.size();++i) count[S[i]] = count[S[i]] + 1;
        vector<int> number;
        vector<int> cn;
        vector<int> c;
        int n = 1;
        for (map<int,int>::iterator it = count.begin(); it!=count.end();++it) {
            number.push_back(it->first);
            cn.push_back(it->second);
            c.push_back(0);
            n *= (it->second +1);
        }
        int d = count.size();
        vector<vector<int> > result;
        result.reserve(n);
        while(true) {
            result.push_back(vector<int>());
            for (int i = 0; i< d; ++i) {
                for (int j=0; j<c[i];++j) {
                    result.back().push_back(number[i]);
                }
            }
            int k;
            for (k=d-1;k>=0;--k) {
                if (c[k]<cn[k]) break;
            }
            if (k<0) break;
            ++c[k];
            for (int i=k+1;i<d;++i) {
                c[i] = 0;
            }
        }
        return result;
    }
};
