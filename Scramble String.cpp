class Solution {
public:
    bool isScramble(string s1, string s2) {
        if (s1.size()!=s2.size()) return false;
        n = s1.size();
        value.clear();
        calculated.clear();
        value.resize(n);
        calculated.resize(n);
        for (int i=2;i<n;++i) {
            int k = n - i + 1;
            value[i].resize(k*k);
            calculated[i].resize(k*k, false);
        }
        this->s1 = &s1;
        this->s2 = &s2;
        if (n==1) return s1[0]==s2[0];
        for (int k=1;k<n; ++k) {
            if (sat(0,0,k) && sat(k,k,n-k)) return true;
            if (sat(0,n-k,k) && sat(k,0,n-k)) return true;
        }
        return false;
    }
    bool sat(int b1, int b2, int len) {
        if (len==1) return s1->at(b1)==s2->at(b2);
        int c = n- len + 1;
        int pos = b1*c + b2;
        if (calculated[len][pos]) return value[len][pos];
        bool val = false;
        for (int k=1;k<len;++k) {
            if (sat(b1,b2,k) && sat(b1+k,b2+k,len-k)) {val=true;break;}
            if (sat(b1,b2+len-k,k) && sat(b1+k,b2,len-k)) {val= true;break;}
        }
        calculated[len][pos] = true;
        value[len][pos] = val;
        return val;
    }
    vector<vector<bool> > value;
    vector<vector<bool> > calculated;
    int n;
    string* s1;
    string* s2;
};