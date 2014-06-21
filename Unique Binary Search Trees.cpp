class Solution {
public:
    int numTrees(int n) {
        vector<int> count(n+1);
        count[0] = 1;
        for (int i=1;i<=n;++i) {
            count[i] = 0;
            for (int j=0;j<i;++j) {
                count[i] += count[j]*count[i-1-j];
            }
        }
        return count[n];
    }
};
