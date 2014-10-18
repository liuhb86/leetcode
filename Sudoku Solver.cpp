class Solution {
public:
    static const int dim = 3;
    static const int size = dim*dim;
    void solveSudoku(vector<vector<char> > &board) {
        solve(board, 0,0); 
    }
    
    bool solve(vector<vector<char> >& board, int row, int col) {
        if (col>=size) {col=0;++row;}
        if (row>=size) return true;
        char& c= board[row][col];
        if (c!='.') return solve(board, row, col+1);
        for (char f='1'; f<='9';++f) {
            if (fit(board, row, col, f)) {
                c=f;
                if (solve(board, row, col+1)) return true;
            }
        }
        c='.';
        return false;
    }
    
    bool fit(vector<vector<char> >&board, int row, int col, char c) {
        for (int i=0;i<size;++i)
            if (board[row][i]==c) return false;
        for (int i=0;i<size;++i)
            if (board[i][col]==c) return false;
        for (int i=0;i<dim;++i)
            for (int j=0;j<dim;++j)
                if (board[row/dim*dim+i][col/dim*dim+j]==c) return false;
        return true;
    }
};