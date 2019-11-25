class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int M = grid.length;
        int N = grid[0].length;
        int MN = M * N;
        int offset = (MN - k % MN) % MN; 
        result.ensureCapacity(M);
        for (int i = 0; i < M; i += 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.ensureCapacity(N);
            result.add(list);
            for (int j =0; j < N; j += 1) {
                int m = offset / N;
                int n = offset % N;
                list.add(grid[m][n]);
                offset = (offset + 1) % MN;
            }
        }
        return result;
    }
}