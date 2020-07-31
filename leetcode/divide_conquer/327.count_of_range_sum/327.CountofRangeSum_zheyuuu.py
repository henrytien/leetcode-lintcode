# Source : https://leetcode.com/problems/count-of-range-sum
# Author : zheyuuu
# Date   : 2020-07-30

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

class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        sums = [0]
        for num in nums:
            sums.append(sums[-1]+num)
        return self.merge(sums, 0, len(sums)-1, lower, upper)
        
    def merge(self, sums, l, r, lower, upper):
        if r-l<=0:
            return 0
        mid = l+(r-l)//2
        lcnt = self.merge(sums, l, mid, lower, upper)
        rcnt = self.merge(sums, mid+1, r, lower, upper)
        cnt = 0
        cache = []
        # right: how many numbers in range [mid+1, r] has been arranged.
        right = mid+1
        # j: 1st number ≥ lower
        # k: 1st number > upper
        # Must place j,k out of loop below, otherwise get TLE. Why we can place them out of loop?
        # If we have nums[j1]-nums[i1]>=lower already.
        # In next step(i2 = i1+1) we cannot garuntee nums[j1]-nums[i2]>=lower. becuase nums[i2]>=nums[i1].
        # So in this step, j.s before j1 is obviously invalid. we have to move j1 to right to find valid position.
        # That's why j is out of loop below(maintain previous position).
        j,k = mid+1,mid+1
        for i in range(l, mid+1):
            while(j<=r and sums[j]-sums[i]<lower):
                j += 1
            while(k<=r and sums[k]-sums[i]<=upper):
                k += 1
            while(right<=r and sums[i]>sums[right]):
                cache.append(sums[right])
                right +=1
            cache.append(sums[i])
            cnt += k-j if k-j>0 else 0
        while(right<=r):
            cache.append(sums[right])
            right += 1

        for i in range(l, r+1):
            sums[i] = cache[i-l]

        # print(sums)
        return lcnt+rcnt+cn
