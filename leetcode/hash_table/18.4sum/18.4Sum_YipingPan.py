# Source : https://leetcode.com/problems/4sum/
# Author : YipingPan
# Date   : 2020-08-16

##################################################################################################### 
#
# Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
# such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of 
# target.
# 
# Note:
# 
# The solution set must not contain duplicate quadruplets.
# 
# Example:
# 
# Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
# 
# A solution set is:
# [
#   [-1,  0, 0, 1],
#   [-2, -1, 1, 2],
#   [-2,  0, 0, 2]
# ]
# 
#####################################################################################################
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        # dic  {sum1:[[i,j],[i,j]], sum2:[[i,j],[i,j]], ...}  # O(n^2)
        # for x in dic: if dic[target-x] ...
        dic = collections.defaultdict(list)
        for i in range(len(nums)):
            for j in range(len(nums)):
                if i<j:
                    dic[nums[i]+nums[j]].append([i,j])
        res = set()
        for x in dic:
            if target-x in dic:   ### be careful here. Don't use  " if dic[target-x] " because it will change the size of dic. 
                for pair1 in dic[x]:
                    for pair2 in dic[target-x]:
                        a,b,c,d = pair1[0],pair1[1],pair2[0],pair2[1]
                        if len(set([a,b,c,d]))==4:
                            res.add(tuple(sorted([nums[a],nums[b],nums[c],nums[d]])))
        return list(res)
                        

