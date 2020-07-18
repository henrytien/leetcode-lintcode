package twopointers;

import java.util.Arrays;

/**
 * Source : https://leetcode.com/problems/3sum-closest/
 * Author: Eve
 * Date: 2020-07-17
 */

/**
 * Description: Given nums, an array of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Constraints:
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 */
class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }
}

/**
 * Time Complexity: O(n*n)
 * Space Complexity: O(n)
 */
