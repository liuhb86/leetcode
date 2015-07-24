class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        if (dungeon.empty() || dungeon.back().empty()) return 1;
        int n = dungeon.back().size();
        vector<int> health(n + 1, INT_MAX);
        health[n-1] = 1;
        for (int i=dungeon.size() -1; i>=0; --i) {
            for (int j=n-1;j>=0;--j) {
                int h = INT_MAX;
                int hh = min(health[j],health[j+1]);
                if (hh <= dungeon[i][j]) {
                    h = 1;
                } else {
                    hh -= dungeon[i][j];
                    if (hh > 0) h=hh;   //overflow check
                }
                health[j] = h;
            }
        }
        return health[0];
    }
};
