class Solution {
public:
    int titleToNumber(string s) {
        int result = 0;
        int totalK = 1;
        int n = 0;
        for (int i=0; i< s.size(); ++i) {
            int d = s[i] - 'A';
            result += totalK;
            totalK *= 26;
            n = n * 26 + d;
        }
        result += n;
        return result;
    }
};
