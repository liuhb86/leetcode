class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s3.size() != s1.size() +s2.size()) return false;
        this->s1 = s1.c_str();
        this->s2 = s2.c_str();
        int m = s1.size() + 1;
        n = s2.size() +1;
        int k = m*n;
        b.resize(k);
        bool r = isInterleave(this->s1, this->s2, s3.c_str());
        b.clear();
        return r;
    }
    bool isInterleave(const char* s1, const char* s2, const char* s3) {
        int i = s1 - this->s1;
        int j = s2 - this->s2;
        int k = i*n + j;
        if (b[k]) return false; 
        while (true) {
            if (*s3=='\0') {return true;}
            if (*s1!=*s2) {
                if (*s1==*s3) {++s1;++s3;continue;}
                if (*s2==*s3) {++s2;++s3;continue;}
                break;
            } else {
                if (*s1 != *s3) break;
                if (isInterleave(s1+1,s2,s3+1)) {return true;}
                ++s2;++s3;continue;
            }
        }
        b[k] = true;
        return false;
    }
    const char* s1;
    const char* s2;
    vector<bool> b;
    int n;
};
