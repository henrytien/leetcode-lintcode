# https://www.lintcode.com/problem/previous-permutation/description
class Solution:
    """
    @param: nums: A list of integers
    @return: A list of integers that's previous permuation
    """
    def previousPermuation(self, nums):
        if not nums or len(nums) == 0:
            return []
        length = len(nums)
        i = length - 1 
        # find the closest node 
        while i > 0 and nums[i] >= nums[i-1]:
            i -= 1
        # ascending order, reversed
        if i == 0:
            return list(reversed(nums))
        # find the right more than nums[i-1]    
        j = length -1
        while j > 0 and nums[j] >= nums[i-1]:
            j -= 1
        # swap
        nums[i-1],nums[j] = nums[j],nums[i-1]
        return nums[:i] + list(reversed(nums[i:]))