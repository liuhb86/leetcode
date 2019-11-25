class Solution {
    public String encode(int num) {
        if (num == 0) return "";
        int k = (int)Math.floor(Math.log(num + 1)/ Math.log(2));
        int m = num + 1 - (1 << k);
        return String.format("%"+k+"s", Integer.toBinaryString(m)).replace(" ", "0");
    }
}