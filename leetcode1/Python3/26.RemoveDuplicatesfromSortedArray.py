# https://leetcode.com/problems/remove-duplicates-from-sorted-array/

# Time complexity:O(n)
# Space complexity:O(1)

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums:
            return 0
        j = 0  # recorder zero
        for i in range(len(nums)):
            if nums[j] != nums[i]:
                j += 1
                nums[j] = nums[i]
        return j+1
