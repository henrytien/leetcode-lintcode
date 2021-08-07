// Source : https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
// Author : Kris
// Date   : 2020-08-28

/***************************************************************************************************** 
 *
 * Given an array arr of positive integers, consider all binary trees such that:
 * 
 * 	Each node has either 0 or 2 children;
 * 	The values of arr correspond to the values of each leaf in an in-order traversal of the 
 * tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * 	The value of each non-leaf node is equal to the product of the largest leaf value in its 
 * left and right subtree respectively.
 * 
 * Among all possible binary trees considered, return the smallest possible sum of the values of each 
 * non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 * 
 * Example 1:
 * 
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node 
 * sum 32.
 * 
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 * 
 * Constraints:
 * 
 * 	2 <= arr.length <= 40
 * 	1 <= arr[i] <= 15
 * 	It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 
 * 2^31).
 ******************************************************************************************************/

class Solution {
    // 贪心：让相邻的最小的两个数组成一对，然后扔掉小的，所以用单调递减栈
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        var result = 0;
        // decreasing
        var stack = new Stack<Integer>();
        var i = 0;
        while (i < arr.length) {
            if (stack.isEmpty() || stack.peek() >= arr[i]) {
                stack.push(arr[i]);
                i++;
            } else {
                var cur = stack.pop();
                if (stack.isEmpty()) {
                    result += cur * arr[i];
                } else {
                    result += cur * Math.min(stack.peek(), arr[i]);
                }
            }
        }
        
        while (stack.size() > 1) {
            result += stack.pop() * stack.peek();
        }
        
        return result;
    }
}