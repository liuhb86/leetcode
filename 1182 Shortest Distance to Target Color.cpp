class Solution {
public:
    vector<int> shortestDistanceColor(vector<int>& colors, vector<vector<int>>& queries) {
        int M = 1000000;
        vector<vector<int> > d(4);
        for(int c = 1; c<=3; c++) {
            int p = -M;
            vector<int>& dc = d[c];
            dc.resize(colors.size());
            for (int i=0; i<colors.size(); i++) {
                if (colors[i] == c) p = i;
                dc[i] = i - p;
            }
            p = M+M;
            for (int i = colors.size() -1; i>=0; i--) {
                if (colors[i]==c) p = i;
                int pi = p-i;
                if (pi < dc[i]) dc[i] = pi;
            }
        }
        vector<int> r(queries.size());
        for (int i=0; i<queries.size(); i++) {
            int v = d[queries[i][1]][queries[i][0]];
            if (v>=M) v = -1;
            r[i] = v;
        }
        return r;
    }
};