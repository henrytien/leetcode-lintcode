/*
 * @Author: John
 * @Email: johnjim0816@gmail.com
 * @Date: 2020-07-27 14:42:41
 * @LastEditor: John
 * @LastEditTime: 2020-07-27 14:45:52
 * @Discription: 
 * @Environment: python 3.7.7
 */ 
// Source : https://leetcode.com/problems/jump-game-ii/
// Author : JohnJim0816
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the 
 * array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 ******************************************************************************************************/

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        int rightmost = 0 , end = 0, step = 0;
        for(int i = 0; i< n-1;i++){
            if(i<=rightmost){
                rightmost = max(rightmost,i+nums[i]);
            }
            if(i==end){
                end = rightmost;
                step++;
            }
        }
        return step;
    }
};