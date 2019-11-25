class Solution {
    public int closedIsland(int[][] grid) {
        int result = 0;
        for (int i = 1; i < grid.length; i += 1) {
            for (int j = 1; j < grid[i].length; j += 1) {
                if (grid[i][j] == 0) {
                    if (flood(grid, i, j) == 2) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * @returns:
     *  1 -- water
     *  2 -- closed island
     *  3 -- boundary / not closed islands
    */
    private int flood(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return 3;
        if (j < 0 || j >= grid[i].length) return 3;
        if (grid[i][j] != 0) return grid[i][j];
        grid[i][j] = 2;
        int result = 2;
        // if either path returns 3, the result will be 3.
        result = Math.max(result, flood(grid, i-1, j));
        result = Math.max(result, flood(grid, i+1, j));
        result = Math.max(result, flood(grid, i, j-1));
        result = Math.max(result, flood(grid, i, j+1));
        grid[i][j] = result;
        return result;
    }
}