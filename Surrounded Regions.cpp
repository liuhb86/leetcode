class Solution {
public:
    struct Pos {
        int x;
        int y;
        Pos(int i, int j):x(i),y(j){}
    };
    void solve(vector<vector<char>> &board) {
        for (int i= 0; i<board.size();++i) {
            for (int j=0;j<board[i].size(); ++j) {
                if (board[i][j]!='O') continue;
                if (check(board, i, j)) {
                    fill(board, i, j);
                }
            }
        }
        
        for (int i= 0; i<board.size();++i) {
            for (int j=0;j<board[i].size(); ++j) {
                if (board[i][j] =='.') board[i][j] = 'O';
            }
        }
    }
    
    bool check(vector<vector<char>> &board, int i, int j) {
        deque<Pos> stack;
        stack.push_back(Pos(i,j));
        bool surrounded = true;
        while(!stack.empty()) {
            Pos p = stack.back();
            stack.pop_back();
            if (p.x<0 || p.x >=board.size()) {surrounded = false; continue;}
            if (p.y<0 || p.y >= board[p.x].size()) {surrounded = false; continue;}
            if (board[p.x][p.y] != 'O') continue; 
            board[p.x][p.y] ='.';
            stack.push_back(Pos(p.x-1, p.y));
            stack.push_back(Pos(p.x+1, p.y));
            stack.push_back(Pos(p.x, p.y-1));
            stack.push_back(Pos(p.x, p.y+1));
        }
        return surrounded;
    }
    
    void fill(vector<vector<char>> &board, int i, int j) {
        deque<Pos> stack;
        stack.push_back(Pos(i,j));
        while(!stack.empty()) {
            Pos p = stack.back();
            stack.pop_back();
            if (board[p.x][p.y]=='.') {
                board[p.x][p.y] = 'X';
                stack.push_back(Pos(p.x-1, p.y));
                stack.push_back(Pos(p.x+1, p.y));
                stack.push_back(Pos(p.x, p.y-1));
                stack.push_back(Pos(p.x, p.y+1));
            }
        }
    }
    
};
