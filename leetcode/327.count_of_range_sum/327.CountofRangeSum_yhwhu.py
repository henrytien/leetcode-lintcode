# Source : https://leetcode.com/problems/count-of-range-sum/
# Author : yhwhu
# Date   : 2020-07-25

##################################################################################################### 
#
# Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
# Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i &le; j), 
# inclusive.
# 
# Note:
# A naive algorithm of O(n2) is trivial. You MUST do better than that.
# 
# Example:
# 
# Input: nums = [-2,5,-1], lower = -2, upper = 2,
# Output: 3 
# Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
# 
# Constraints:
# 
# 	0 <= nums.length <= 10^4
#####################################################################################################


import bisect
class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        # 构造前缀和数组
        n = len(nums)
        preSum = [0 for i in range(n + 1)]
        if nums is None or len(nums) == 0:
            return 0
        for i in range(n):
            preSum[i + 1] = preSum[i] + nums[i]
        # 前缀和数组中必须有一个前缀0作为辅助位置
        return self.merge(preSum, lower, upper)

    def merge(self, nums: List[int], lower, upper):
        if len(nums) <= 1:
            return 0
        cnt = 0
        n = len(nums)
        mid = n // 2
        left = nums[:mid]
        right = nums[mid:]
        cnt += self.merge(left, lower, upper)
        cnt += self.merge(right, lower, upper)
        i = 0
        j = 0
        low = 0
        up = 0
        # 归并过程
        while i < mid:
            while low < len(right) and right[low] - left[i] < lower:
                low += 1
            while up < len(right) and right[up] - left[i] <= upper:
                up += 1
            cnt += up - low
            i += 1
        # 归并排序过程
        i = 0
        j = 0
        k = 0
        while i < len(left) and j < len(right):
            # 谁小移动谁
            if left[i] < right[j]:
                nums[k] = left[i]
                i += 1
            else:
                nums[k] = right[j]
                j += 1
            k += 1
        # 总有一个要出界
        while i < len(left):
            nums[k] = left[i]
            k += 1
            i += 1
        while j < len(right):
            nums[k] = right[j]
            k += 1
            j += 1
        return cnt
