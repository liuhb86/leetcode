class Solution {
    public List<String> addOperators(String num, int target) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        addOperators(num, target, 0, sb, result, 0, 1, false);
        return result;
    }
    
    private void addOperators(String num, int target, int start, StringBuilder sb, List<String> result, long sum, long factor, boolean isMul) {
        if (start == num.length()) {
            if (isMul) {
                sum += factor;
                if (sum == target) {
                    String s = sb.toString();
                    result.add(s.substring(0, s.length() - 1));
                }
            }
            return;
        }
        
        int endIndex = (num.charAt(start) == '0') ? start + 1 : num.length();
        long number = 0;
        int prevLength = sb.length();
        for (int i = start; i < endIndex; ++i) {
            sb.append(num.charAt(i));
            number = number * 10 + num.charAt(i) - '0';
            sb.append('+');
            addOperators(num, target, i+1, sb, result, sum + factor * number, 1, false);
            sb.setLength(sb.length() - 1);
            sb.append('-');
            addOperators(num, target, i+1, sb, result, sum + factor * number, -1, false);
            sb.setLength(sb.length() - 1);
            sb.append('*');
            addOperators(num, target, i+1, sb, result, sum, factor * number, true);
            sb.setLength(sb.length() - 1);
        }
        sb.setLength(prevLength);
    }
}