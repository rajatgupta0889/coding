package com.learn.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    /*
     * https://leetcode.com/problems/rotting-oranges/
     * 994. Rotting Oranges
     * */
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, time = 0;

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Perform BFS
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0], col = current[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // If the adjacent cell is a fresh orange, rot it
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                    }
                }
            }
            time++;
        }

        // If there are still fresh oranges, return -1
        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rottenOranges.orangesRotting(grid)); // Output: 4
    }
}
