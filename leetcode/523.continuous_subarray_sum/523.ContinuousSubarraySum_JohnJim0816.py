#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-08 14:03:46
LastEditor: John
LastEditTime: 2020-08-08 20:17:13
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/continuous-subarray-sum/
# Author : JohnJim0816
# Date   : 2020-08-08

##################################################################################################### 
#
# Given a list of non-negative numbers and a target integer k, write a function to check if the array 
# has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to 
# n*k where n is also an integer.
# 
# Example 1:
# 
# Input: [23, 2, 4, 6, 7],  k=6
# Output: True
# Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
# 
# Example 2:
# 
# Input: [23, 2, 6, 4, 7],  k=6
# Output: True
# Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
# 
# Constraints:
# 
# 	The length of the array won't exceed 10,000.
# 	You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
#####################################################################################################

class Solution:
    '''优化暴力法
    '''
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        sum=[nums[0]]
        # 先存数组的累积和
        for i in range(1,len(nums)):
            sum.append(sum[i-1]+nums[i])
        for i in range(len(nums)-1):
            for j in range(i+1,len(nums)):
                summ=sum[j]-sum[i]+nums[i]
                if summ==k or (k!=0 and summ%k==0):
                    return True
        return False

class Solution:
    '''哈希表法，该方法有错！！！针对[3,6,0] k=6或[0,0],-1的情况没法通过，原因是每次都会dict[preSum] = i ，比如preSum[0]%k=3，preSum[1]%k=3,此时dict中的{3:0}会变成{3:1}，实际上我们需要找到3对应的第一个下标和最后一个就行，并且两者之差>1
    '''
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums)<2 : return False
        ## k == 0时另外判断
        if k == 0:
            for i in range(len(nums)-1):
                if nums[i]== 0 and nums[i+1] == 0:
                    return True
            return False
        preSum = 0
        dict = {0:-1} # 针对[23,2,6,4,7], k = 6等全数组和才是k的倍数的情况需要加一个辅助空间
        for i in range(len(nums)):
            preSum += nums[i]
            preSum %= k
            pre_idx = dict.get(preSum)
            if dict.get(preSum):
                if i - pre_idx > 1:
                    return True
            else:
                dict[preSum] = i  
        return False


'''
易错示例

[0,0]
-1

[0]
-1

[23,2,6,4,7]
6
'''

class Solution:
    '''哈希表法，可以通过！！！
    '''
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums)<2 : return False
        ## k == 0时另外判断
        if k == 0:
            for i in range(len(nums)-1):
                if nums[i]== 0 and nums[i+1] == 0:
                    return True
            return False
        preSum = 0
        dict = {0:-1} # 针对[23,2,6,4,7], k = 6等全数组和才是k的倍数的情况需要加一个辅助空间
        for i in range(len(nums)):
            preSum += nums[i]
            preSum %= k
            if dict.get(preSum) is not None:
                pre_idx = dict.get(preSum)
                if i - pre_idx > 1:
                    return True
            else:
                dict[preSum] = i  
        return False


class Solution:
    ''' 哈希表法，使用更高级的setdefault
    '''
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        if len(nums) < 2: return False
        dp, cur = {0: -1}, 0
        for idx, num in enumerate(nums):
            cur += num
            if k != 0: cur %= k
            pre = dp.setdefault(cur, idx)
            if idx - pre > 1: return True
        return False

