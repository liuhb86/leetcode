class Solution {
public:
    int numDistinct(string S, string T) {
        int tlen = T.size();
        int slen = S.size();
        int* count = new int[tlen + 1];
        count[0] = 1;
        for (int i = 1; i <= tlen; ++i) count[i] = 0;
        for (int i = 1; i<= S.size(); ++i) {
            for (int j = tlen; j >= 1; --j) {
                if (j > i) count[j] = 0;
                if (S[i-1] == T[j -1]) {
                    count[j] += count[j-1];
                }
            }
        }
        return count[tlen];
    }
};
