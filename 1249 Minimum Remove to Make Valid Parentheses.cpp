class Solution {
public:
    string minRemoveToMakeValid(string s) {
        vector<int> lp;
        int len = s.size();
        for (int i = 0; i<s.size(); ++i) {
            if (s[i] == '(') {
                lp.push_back(i);
            } else if (s[i] ==')') {
                if (lp.empty()) {
                    s[i] = '*';
                    len -= 1;
                } else {
                    lp.pop_back();
                }
            }
        }
        len -= lp.size();
        for (auto i : lp) {
            s[i] = '*';
        }
        string r;
        r.reserve(len);
        for (int i=0;r.size() < len; ++i) {
            if (s[i] != '*') {
                r.push_back(s[i]);
            }
        }
        return r;
    }
};