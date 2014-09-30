class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0;
        int j= s.size() - 1;
        while (i<j) {
            char c1 = trim(s[i]);
            if (c1=='\0') {++i;continue;}
            char c2 = trim(s[j]);
            if (c2 == '\0') {--j; continue;}
            if (c1 != c2) return false;
            ++i;--j;
        }
        return true;
    }
    
    char trim(char c) {
        if (c>='a' && c<='z')
            return c-'a' +'A';
        else if (c>='A' && c<='Z')
            return c;
        else if (c>='0' && c<='9')
            return c;
        else
            return '\0';
    }
};