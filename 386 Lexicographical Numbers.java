class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        for (int first=1;first<=9; first+=1) {
            if (!solve(first, n, result)) break;
        }
        return result;
    }
    
    public boolean solve(int base, int limit, List<Integer> result) {
        if (base > limit) return false;
        result.add(base);
        base = base * 10;
        for (int i = 0; i<=9; i+=1) {
            int n = base + i;
            if (!solve(n, limit, result)) return true;
        }
        return true;
    }
}