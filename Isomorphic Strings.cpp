class Solution {
public:
    bool isIsomorphic(string s, string t) {
        normalize(s);
        normalize(t);
        return s==t;
    }
    void normalize(string& s) {
        int c = 0;
        char mapping[256] = {0};
        for (int i=0; i<s.size();++i) {
            if (mapping[s[i]] != 0) {
                s[i] = mapping[s[i]];
            } else {
                mapping[s[i]] = ++c;
                s[i] = c;
            }
        }
    }
};
