class Solution {
    private static final long M = 1000000007L;
    public int numWays(int steps, int arrLen) {
        int n = Math.min(steps, arrLen);
        long[] dp = new long[n+3];
        long[] dp2 = new long[n+3];
        dp[1] = 1;
        for (int k = 1; k <= steps; k+=1) {
            int m = Math.min(k+1, arrLen);
            for (int i = 1; i <= m; i+=1) {
                dp2[i] = (dp[i-1] + dp[i] + dp[i+1]) % M;
            }
            long[] t = dp; dp = dp2; dp2 = t;
        }
        return (int)dp[1];
    }
}