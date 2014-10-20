class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) {
        int m=matrix.size();
        int n = m>0 ? matrix.back().size() : 0;
        int result = 0;
        
        vector<int> height(n+1,0);
        
        for (int i=0;i<m;++i) {
            for (int j=0;j<n;++j) {
                height[j] = matrix[i][j]=='1'? (height[j]+1) :0;
            }
            
            deque<int> stack;
            for (int j=0;j<=n;++j) {
                while(!stack.empty() && height[j]<=height[stack.back()]) {
                    int h = stack.back();
                    stack.pop_back();
                    int A = height[h] * (stack.empty()?j:(j-stack.back()-1));
                    result = max(result,A);
                }
                stack.push_back(j);
            }
        }
        
        return result;
    }
};