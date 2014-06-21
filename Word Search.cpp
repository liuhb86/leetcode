class Solution {
public:
    bool exist(int i, int j, int k) {
        if (k==l) return true;
        if (i<0 || i>=m) return false;
        if (j<0 || j>=n) return false;
        if ((*board)[i][j]!=word->at(k)) return false;
        (*board)[i][j]=0;
        bool result = (exist(i+1,j,k+1) 
        || exist(i,j+1,k+1)
        || exist(i-1, j,k+1)
        || exist(i,j-1,k+1)
        );
        
        (*board)[i][j] = word->at(k);
        return result;
    }
    bool exist(vector<vector<char> > &board, string word) {
        this->board=&board;
        this->word=&word;
        m= board.size();
        l = word.size();
        if (word.size()==0) return true;
        if (m==0) return false;
        n = board.back().size();
        for (int i=0;i<m;++i) {
            for (int j=0; j<n;++j) {
                if (exist(i,j,0)) return true;
            }
        }
        return false;
    }
private:
    vector<vector<char> >* board;
    int m;
    int n;
    int l;
    string* word;
};
