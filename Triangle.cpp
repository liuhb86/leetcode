class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        if (triangle.empty()) return 0;
        int size = triangle.size();
        vector<int> sum(size);
        sum[0] = triangle[0][0];
        for (int i= 1; i < size; ++i) {
            int t = sum[0];
            sum[i] = sum[i-1] + triangle[i][i];
            for (int j = i-1; j>=1; --j) {
                sum[j] = min(sum[j], sum[j-1]) + triangle[i][j];
            }
            sum[0] = t + triangle[i][0];
        }
        
        int m = sum[0];
        for (int i=1;i<size;++i) {
            if (sum[i]<m) m=sum[i];
        }
        return m;
    }
};