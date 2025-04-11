package com.learn.dsa.arraysNhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    /*
     * https://leetcode.com/problems/valid-sudoku/
     * 36. Valid Sudoku
     * */
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for(int r = 0; r <9; r++){
            for(int c =0 ; c <9; c++){


                if(board[r][c] == '.')
                    continue;
                String squareKey = (r/3) + "-" + (c/3);
                char b = board[r][c];
                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(b)
            || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(b) ||
                square.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(b)){
                    return false;
                }

                rows.get(r).add(b);
                cols.get(c).add(b);
                square.get(squareKey).add(b);

            }
        }
        return true;

    }
}
