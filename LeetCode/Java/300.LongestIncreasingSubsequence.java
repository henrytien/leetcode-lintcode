// Source : https://leetcode.com/problems/longest-increasing-subsequence/
// Author : Ubique0305
// Date   : 2020-07-15

/***************************************************************************************************** 
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * Note: 
 * 
 * 	There may be more than one LIS combination, it is only necessary for you to return the 
 * length.
 * 	Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 ******************************************************************************************************/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] help = new int[nums.length];
        help[0] = nums[0];

        int end = 0;
        for(int i = 1; i < nums.length; i++){
            if(help[end] < nums[i])
                help[++end] = nums[i];
            else{
                binarySearch(help,end,nums[i]);
            } 
        }
        return end+1;
    }

    void binarySearch(int[] nums,int end,int target){
        int l = 0;
        int r = end;
        while(l < r){
            int mid = (l + r) >>> 1;
            if(nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        nums[l] = target;
    }
}
/*
 * TODO patch a link of how to write a right binary search
 */
