package com.learn.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    /**
     * https://leetcode.com/problems/pacific-atlantic-water-flow/
     * 417. Pacific Atlantic Water Flow
     */
    public static int[][] directions = new int[][]{
            {1,0},{-1,0}, {0,1},{0,-1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows= heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            dfs(heights,pacific,r, 0, heights[r][0]);
            dfs(heights,atlantic,r, cols-1, heights[r][cols-1]);
        }

        for(int c = 0; c < cols; c++){
            dfs(heights,pacific,0, c, heights[0][c]);
            dfs(heights,atlantic,rows-1, c, heights[rows-1][c]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0 ; r < rows; r++){
            for(int c = 0; c< cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight){
        if( r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c] || heights[r][c] < prevHeight){
            return;
        }

        visited[r][c]  = true;
        for(int[] dir : directions){
            dfs(heights, visited, r + dir[0], c + dir[1], heights[r][c]);
        }

    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        List<List<Integer>> result = pacificAtlanticWaterFlow.pacificAtlantic(heights);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
