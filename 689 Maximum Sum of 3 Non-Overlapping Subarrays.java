class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum  = 0;
        for (int i = nums.length -1 ; i >= 0; --i) {
            sum += nums[i];
        }
        
        int[] sumk = new int[nums.length];
        for (int i = nums.length - k; i >= 0; --i) {
            sum += nums[i];
            sumk[i] = sum;
            sum -= nums[i + k -1 ];
        }
        
        int[][] dp = new int[4][nums.length + 1];
        int[][] dpIndex = new int[4][nums.length + 1];
        for (int m = 1; m <= 3; ++m) {
            for (int i = nums.length - m*k; i >= 0; --i) {
                int v = sumk[i] + dp[m-1][i+k];
                if (v >= dp[m][i+1]) {
                    dp[m][i] = v;
                    dpIndex[m][i] = i;
                } else {
                    dp[m][i] = dp[m][i+1];
                    dpIndex[m][i] = dpIndex[m][i+1];
                }
            }
        }
        int[] result = new int[3];
        int startIndex = 0;
        for (int i = 0; i < 3; ++i) {
            result[i] = dpIndex[3-i][startIndex];
            startIndex = result[i] + k;
        }
        return result;
    }
}
