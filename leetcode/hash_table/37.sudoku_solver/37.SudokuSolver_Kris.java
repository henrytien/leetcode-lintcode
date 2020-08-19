// Source : https://leetcode.com/problems/sudoku-solver/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 	Each of the digits 1-9 must occur exactly once in each row.
 * 	Each of the digits 1-9 must occur exactly once in each column.
 * 	Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the 
 * grid.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * A sudoku puzzle...
 * 
 * ...and its solution numbers marked in red.
 * 
 * Note:
 * 
 * 	The given board contain only digits 1-9 and the character '.'.
 * 	You may assume that the given Sudoku puzzle will have a single unique solution.
 * 	The given board size is always 9x9.
 * 
 ******************************************************************************************************/

class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        
        solve(board, 0, 0);
    }
    
    boolean solve(char[][] board, int row, int column) {
        if (row >= board.length) {
            return true;
        }
        
        var newRow = column >= board[0].length - 1 ? row + 1 : row;
        var newColumn = column >= board[0].length - 1 ? 0 : column + 1;
        
        if (board[row][column] == '.') {
            for (var c = '1'; c <= '9'; c++) {
                if (isValid(board, row, column, c)) {
                    board[row][column] = c;
                    if (solve(board, newRow, newColumn)) {
                        return true;
                    }
                    board[row][column] = '.';
                }
            }
        } else {
            return solve(board, newRow, newColumn);
        }
        
        return false;
    }
    
    boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == c) return false;
            if(board[row][i] == c) return false;
        }
        
        var iBox = row - row % 3;
        var jBox = col - col % 3;
        for (var i = 0; i < 3; i++) {
            for (var j = 0; j < 3; j++) {
                if (board[iBox + i][jBox + j] == c) {
                    return false;
                }
            }
        }
        
        return true;
    }
}