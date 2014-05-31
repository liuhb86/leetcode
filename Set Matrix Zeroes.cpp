class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
        if (matrix.size()==0) return;
        int m = matrix.size();
        int n = matrix[0].size();
        int clearCol = -1;
        int clearRow = -1;
        vector<vector<int> >& A=matrix;
        for (int j=0;j<n;++j) {
            for (int i=0;i<m;++i) {
                if (A[i][j]==0) {
                    clearCol = j;
                    clearRow = i;
                    A[clearRow][clearCol]=0;
                    goto BREAK;
                }
            }
        }
        BREAK:
        if (clearCol<0) return;

        for (int i=0;i<m;++i) {
            for (int j=clearCol+1;j<n;++j) {
                if (A[i][j]==0) {
                    A[i][clearCol] = 0;
                    A[clearRow][j] = 0;
                }
            }
        }
        for (int i=0;i<m;++i) {
            if (i==clearRow) continue;
            if (A[i][clearCol]==0) {
                for (int j=0;j<n;++j) A[i][j] =0;
            }
        }
        for (int j=0;j<n;++j) {
            if (A[clearRow][j]==0) {
                for (int i=0;i<m;++i) A[i][j] = 0;
            }
        }
        for (int j=0;j<n;++j) A[clearRow][j]=0;
    }
    static void main() {
	   vector<vector<int> > matrix(1);
	   matrix[0].push_back(0);
	   matrix[0].push_back(1);
	   Solution s;
	   s.setZeroes(matrix);
    }
};
