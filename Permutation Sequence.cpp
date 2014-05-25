class Solution {
public:
    string getPermutation(int n, int k) {
        string result;
        if (n <= 0) return result;
        --k;
        result.reserve(n);
        vector<char> numbers(n);
        for (int i=0;i<n;++i) numbers[i] = '0' + i + 1;
        int f = 1;
        for (int i = 2;i<=n;++i) f *= i;
        k = k % f;
        for (int i=n;i>=1;--i) {
            f /= i;
            int j = k / f;
            k = k % f;
            result.push_back(numbers[j]);
            numbers.erase(numbers.begin() + j);
        }
        return result;
    }
};