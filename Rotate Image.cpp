#include<vector>
#include<iostream>
using namespace std;

class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        int size = matrix.size();
        int nRow = size/2;
        int nCol = (size+1)/2;
        int c = (size*2 -1)/2;
        for (int i=0;i<nRow; ++i) {
            for (int j=0;j<nCol;++j) {
                int v;
                int i1=(i<<1) -c, j1=(j<<1) - c;
                for (int phase=0; phase<=4;++phase) {
                    int* p = &(matrix[(i1+c)>>1][(j1+c)>>1]);
                    int t= *p;
                    *p = v;
                    v = t;
                    t = i1;
                    i1 = j1;
                    j1 = -t;
                }
            }
        }
    }
    static void main()
    {
        int A[2][2] = {{1,2},{3,4}};
        int n = 2;
        vector<vector<int> > matrix;
        matrix.resize(n);
        for (int i=0;i<n;++i) {
            matrix[i].resize(n);
            for (int j=0;j<n;++j) matrix[i][j] = A[i][j];
        }
        Solution s;
        s.rotate(matrix);
        for (int i=0;i<n;++i) {
            for (int j=0;j<n;++j) {
                cout<<matrix[i][j]<<' ';
            }
            cout<<endl;
        }
    }
};
