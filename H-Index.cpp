class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> count(n+1);
        for (int i=0; i<n; ++i) {
            if (citations[i]>=n)
                ++count[n];
            else
                ++count[citations[i]];
        }
        int c = 0;
        for (int i=n;i>=0;--i) {
            c+=count[i];
            if (c>=i) return i;
        }
        return 0;
    }
};
