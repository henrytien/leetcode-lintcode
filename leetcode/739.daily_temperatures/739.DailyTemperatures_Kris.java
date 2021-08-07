// Source : https://leetcode.com/problems/daily-temperatures/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * 
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you 
 * how many days you would have to wait until a warmer temperature.  If there is no future day for 
 * which this is possible, put 0 instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output 
 * should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 ******************************************************************************************************/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        
        var result = new int[T.length];
        var index = 0;
        // decreasing
        var stack = new Stack<Integer>();
        while (index < T.length) {
            if (stack.isEmpty()) {
                stack.push(index);
                index++;
            } else if (T[stack.peek()] < T[index]) {
                var cur = stack.pop();
                result[cur] = index - cur;
            } else if (T[stack.peek()] >= T[index]) {
                stack.push(index);
                index++;
            }
        }
        
        return result;
    }
}