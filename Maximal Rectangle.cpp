class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) {
        int m = matrix.size();
        if (m==0) return 0;
        int n = matrix[0].size();
        vector<vector<int > > to(m);
        for (int i=0;i<m;++i) {
            to[i].resize(n);
        }
        for (int j=0;j<n;++j) {
            int start = 0;
            for (int i=0;i<m;++i) {
                if (matrix[i][j]=='0') {
                    to[i][j] = -1;
                    while(start<i) to[start++][j] = i-1;
                    start = i + 1;
                }
            }
            while(start<m) to[start++][j] = m - 1;
        }
        int maxArea = 0;
        for (int height = m;height>=1;--height) {
            if (height*n<=maxArea) break;
            int minCol = maxArea/height;
            if (minCol*height<=maxArea) ++minCol;
            int endRow = m - height;
            for(int startRow = 0; startRow <=endRow;++startRow) {
                int toRow = startRow + height -1;
                int area = 0;
                for(int j=0;j<n;++j) {
                    if (to[startRow][j]>=toRow) {
                        area += height;
                    } else {
                        if (area>maxArea) {
                            maxArea = area;
                            minCol = maxArea/height;
                            if (minCol*height<=maxArea) ++minCol;
                        }
                        area = 0;
                        if (n-j-1<minCol) break;
                    }
                }
                if (area>maxArea) {
                    maxArea = area;
                    minCol = maxArea/height;
                    if (minCol*height<=maxArea) ++minCol;
                }
            }
        }
        return maxArea;
    }

    static void main() {
        const char* input[] = {"00010111","01100101","10111101","00010000","00100010","11100111","10011001","01001100","10010000"};
        vector<vector<char> > matrix(9);
        for (int i=0;i<9;++i) {
            matrix[i].resize(8);
            for (int j=0;j<8;++j) {
                matrix[i][j]=input[i][j];
            }
        }
        Solution s;
        cout<<s.maximalRectangle(matrix);
    }
};
