#https://www.lintcode.com/problem/next-permutation/description

class Solution:
    """
    @param nums: A list of integers
    @return: A list of integers
    """
    def nextPermutation(self, nums):
        n = len(nums)
        pivot = -1
        for i in range(n-2,-1,-1):
            if nums[i] < nums[i+1]:
                pivot = i
                break;
                
        if pivot == -1:
            return [*reversed(nums)]
            
        for i in range(n-1,pivot,-1):
            if nums[i] > nums[pivot]:
                nums[i],nums[pivot] = nums[pivot],nums[i]
                break
            
        i,j = pivot + 1, n -1 
        while i < j:
            nums[i],nums[j] = nums[j],nums[i]
            i += 1 
            j -= 1 
        return nums
            
