// Source : https://leetcode.com/problems/container-with-most-water/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, 
 * ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
 * Find two lines, which, together with the x-axis forms a container, such that the container contains 
 * the most water.
 * 
 * Notice that you may not slant the container.
 * 
 * Example 1:
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, 
 * the max area of water (blue section) the container can contain is 49.
 * 
 * Example 2:
 * 
 * Input: height = [1,1]
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * 
 * Example 4:
 * 
 * Input: height = [1,2,1]
 * Output: 2
 * 
 * Constraints:
 * 
 * 	2 <= height.length <= 3 * 104
 * 	0 <= height[i] <= 3 * 104
 ******************************************************************************************************/

class Solution {
    // O(n)
    public int maxArea(int[] height) {
        var left = 0;
        var right = height.length - 1;
        
        var max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
    
    // Bruce Force O(n^2)
    public int maxArea_oNxN(int[] height) {
        var n = height.length;
        var max = 0;
        for (var i = 0; i < n; i++) {
            for (var j = i + 1; j < n; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        
        return max;
    }
}