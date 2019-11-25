// f(n) = \sum f(i-2) * f(n - i)
class Solution {
    private static long M = 1000000007L;
    public int numberOfWays(int num_people) {
        long[] dp = new long[num_people + 1];
        dp[0] = 1;
        for (int k = 2; k <= num_people; k += 2) {
            long count = 0;
            for (int i = 2; i <= k ; i += 2) {
                count = (count + dp[i-2] * dp[k - i]) % M;
            }
            dp[k] = count;
        }
        return (int)dp[num_people];
    }
}