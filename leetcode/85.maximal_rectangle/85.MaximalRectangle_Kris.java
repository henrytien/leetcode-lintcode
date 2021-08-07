// Source : https://leetcode.com/problems/maximal-rectangle/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing 
 * only 1's and return its area.
 * 
 * Example 1:
 * 
 * Input: matrix = 
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * 
 * Example 2:
 * 
 * Input: matrix = []
 * Output: 0
 * 
 * Example 3:
 * 
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * Example 4:
 * 
 * Input: matrix = [["1"]]
 * Output: 1
 * 
 * Example 5:
 * 
 * Input: matrix = [["0","0"]]
 * Output: 0
 * 
 * Constraints:
 * 
 * 	rows == matrix.length
 * 	cols == matrix.length
 * 	0 <= row, cols <= 200
 * 	matrix[i][j] is '0' or '1'.
 ******************************************************************************************************/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        var max = 0;
        var nums = new int[matrix[0].length];
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                nums[j] = matrix[i][j] == '1' ? nums[j] + 1 : 0;
            }
            
            max = Math.max(max, helper(nums));
        }
        
        return max;
    }
    
    int helper(int[] heights) {
        // 单调递增栈
        var stack = new Stack<Integer>();
        var left = new int[heights.length];
        var right = new int[heights.length];
        
        for (var i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (heights[stack.peek()] < heights[i]) {
                left[i] = stack.peek() + 1;
                stack.push(i);
            } else if (heights[stack.peek()] == heights[i]) {
                left[i] = left[stack.peek()];
                stack.push(i);
            } else {
                right[stack.pop()] = i;
                i--;
            }
        }
        
        while (!stack.isEmpty()) {
            right[stack.pop()] = heights.length;
        }
        
        var max = 0;
        for (var i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i]) * heights[i]);
        }
        
        return max;
    }
}