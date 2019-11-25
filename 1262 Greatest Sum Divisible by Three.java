class Solution {
    public int maxSumDivThree(int[] nums) {
        final int M = 100000;
        int s11 = M;
        int s12 = M;
        int s21 = M;
        int s22 = M;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            if (n % 3 == 1) {
                if (n < s11) {
                    s12 = s11;
                    s11 = n;
                } else if (n < s12) {
                    s12 = n;
                }
            } else if (n % 3 == 2) {
                if (n < s21) {
                    s22 = s21;
                    s21 = n;
                } else if (n < s22) {
                    s22 = n;
                }
            }
        }
        int result = 0;
        if (sum % 3 == 0) {
           result = sum;
        } else if (sum % 3 == 1) {
            if (s11 < M) {
                result = Math.max(result, sum - s11);
            }
            if (s22 < M) {
                result = Math.max(result, sum - s21-s22);
            }
        } else { // sum % 3 == 2
            if (s21 < M) {
                result = Math.max(result, sum - s21);
            }
            if (s12 < M) {
                result = Math.max(result, sum - s11 - s12);
            }
        }
        return result;
    }
}