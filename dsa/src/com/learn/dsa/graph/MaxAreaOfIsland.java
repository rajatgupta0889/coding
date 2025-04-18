package com.learn.dsa.graph;

public class MaxAreaOfIsland {
    /**
     * https://leetcode.com/problems/max-area-of-island/
     * 695. Max Area of Island
     */

    private static int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c <cols ; c++){
                if(grid[r][c] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r <0 || r > grid.length || c > grid[0].length || c < 0 || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0; // Mark the cell as visited
        int area = 1; // Count the current cell
        for(int[] direction : directions){
            int newRow = r + direction[0];
            int newCol = c + direction[1];
            area += dfs(grid, newRow, newCol);
        }
        return area;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid = {
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,1,1,1,0},
                {0,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid)); // Output: 6
    }
}
