//fibonacci

class Solution {
public:
    int climbStairs(int n) {
        if (n<2) return 1;
        int f2 = 1;
        int f1 = 1;
        Matrix22 f;
        f.v[0][0]=f.v[0][1]=f.v[1][0]=1; f.v[1][1]=0;
        Matrix22 r = matrixPow(f,n);
        return r.v[0][0];
    }
private:
    struct Matrix22 {
      int v[2][2];  
    };
    Matrix22 matrixMul(Matrix22 a, Matrix22 b) {
        Matrix22 r;
        for (int i=0;i<2;++i) {
            for (int j=0;j<2;++j) {
                r.v[i][j] = 0;
                for (int k=0;k<2;++k) {
                    r.v[i][j]+=a.v[i][k]*b.v[k][j];
                }
            }
        }
        return r;
    }
    Matrix22 matrixPow(Matrix22 a, int n)
    {
        Matrix22 r;
        r.v[0][0]=r.v[1][1]=1;
        r.v[0][1]=r.v[1][0]=0;
        if (n<=0) return r;
        
        while(n > 0) {
            if (n&1) r=matrixMul(r,a);
            n>>=1;
            if (n==0) break;
            a = matrixMul(a,a);
        }
        return r;
        
    }
};
