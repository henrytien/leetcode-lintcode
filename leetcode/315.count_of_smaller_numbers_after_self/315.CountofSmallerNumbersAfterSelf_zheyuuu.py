# Source : https://leetcode.com/problems/count-of-smaller-numbers-after-self/
# Author : zheyuuu
# Date   : 2020-07-27

##################################################################################################### 
#
# You are given an integer array nums and you have to return a new counts array. The counts array has 
# the property where counts[i] is the number of smaller elements to the right of nums[i].
# 
# Example:
# 
# Input: [5,2,6,1]
# Output: [2,1,1,0] 
# Explanation:
# To the right of 5 there are 2 smaller elements (2 and 1).
# To the right of 2 there is only 1 smaller element (1).
# To the right of 6 there is 1 smaller element (1).
# To the right of 1 there is 0 smaller element.
#####################################################################################################

class Solution:
    # O(n^2) TLE
    def countSmaller(self, nums: List[int]) -> List[int]:
        ans = []
        for i in range(len(nums)):
            cnt = 0
            for j in range(i+1, len(nums)):
                if nums[j]<nums[i]:
                    cnt +=1
            ans.append(cnt)
        return ans
    # MergeSort O(nlogn)
    def countSmaller(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        def mergeSort(nums, l, r):
            if l==r:
                return [[l, 0]]
            mid = (l+r)//2
            a = mergeSort(nums, l, mid)
            b = mergeSort(nums, mid+1, r)
            tmp = []
            cnt = 0
            while(a and b):
                if nums[a[0][0]]<=nums[b[0][0]]:
                    tmp.append([a[0][0], a[0][1]+cnt])
                    a.pop(0)
                else:
                    cnt+=1
                    tmp.append(b[0])
                    b.pop(0)
            if a:
                for aa in a:
                    tmp.append([aa[0], aa[1]+cnt])
            if b:
                tmp.extend(b)
            return tmp
        tmp = mergeSort(nums, 0, len(nums)-1)
        map = {k:v for k,v in tmp}
        ans = [map[i] for i in range(len(nums))]
        return ans
                
            
    
