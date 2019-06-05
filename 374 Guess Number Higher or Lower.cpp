// Forward declaration of guess API.
// @param num, your guess
// @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution {
public:
    int guessNumber(int n) {
        unsigned int begin = 1;
        unsigned int end = ((unsigned int) n) + 1;
        while (end - begin > 1) {
            unsigned int mid = begin + (end -begin- 1) / 2;
            int t = guess(mid);
            //printf("%d,%d\n", mid, t);
            if (t == 0) return mid;
            if (t < 0) end = mid;
            else begin = mid + 1;
        }
        return begin;
    }
};