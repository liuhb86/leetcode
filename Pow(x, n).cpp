class Solution {
public:
    double pow(double x, int n) {
        if (n==0) return (x==0)? NAN: 1;
        double p = pow(x, n/2);
        if (n%2==0) return p*p;
        if (n>0) return p*p*x;
        return p*p/x;
    }
};