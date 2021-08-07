// Source : https://leetcode.com/problems/trapping-rain-water/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of 
 * rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 ******************************************************************************************************/

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        var left = 0;
        var right = height.length - 1;
                
        var min = 0;        
        var result = 0;
        while (left < right) {
            if (height[left] < min) {
                result += min - height[left];
                left++;
            } else if (height[left] == min) {
                left++;
            } else if (height[right] < min) {
                result += min - height[right];
                right--;
            } else if (height[right] == min) {
                right--;
            } else {
                min = Math.min(height[left], height[right]);
            }
        }
        
        return result;
    }
}