class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        bool isSet[10];
        for(int i=0;i<9;++i)
        {
            memset(isSet, 0, sizeof(bool)*10);
            for(int j=0;j<9;++j)
            {
                if (!validate(board,i,j,isSet)) return false;
            }
        }
        
        for(int i=0;i<9;++i)
        {
            memset(isSet, 0, sizeof(bool)*10);
            for(int j=0;j<9;++j)
            {
                if (!validate(board,j,i,isSet)) return false;
            }
        }
        
        for(int iRowBlock=0; iRowBlock<3;++iRowBlock)
        {
            for (int iColBlock=0; iColBlock<3;++iColBlock)
            {
                memset(isSet, 0, sizeof(bool)*10);
                for(int iRow=0; iRow<3;++iRow){
                    for(int iCol=0; iCol<3;++iCol)
                    {
                        if(!validate(board, iRowBlock*3+iRow, iColBlock*3+iCol,isSet))
                            return false;
                    }
                }
            }
        }
        return true;
    }
private:
    bool validate(vector<vector<char> >& board, int row, int col, bool* isSet)
    {
        char c = board[row][col];
        if (c=='.') return true;
        int i = c-'0';
        if (isSet[i]) return false;
        isSet[i]=true;
        return true;
    }
};