#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-17 19:22:35
@LastEditor: John
@LastEditTime: 2020-07-17 19:25:51
@Discription: 
@Environment: python 3.7.7
'''
'''python中可以用字典模拟hashmap
'''
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        '''两遍哈希表
        '''
        hashmap={}
        for ind,num in enumerate(nums):
            hashmap[num] = ind
        for i,num in enumerate(nums):
            j = hashmap.get(target - num)
            if j is not None and i!=j:
                return [i,j]


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        '''一遍哈希表
        '''
        hashmap={}
        for i,num in enumerate(nums):
            if hashmap.get(target - num) is not None:
                return [hashmap.get(target - num),i]
            hashmap[num] = i #这句不能放在if语句之前，解决list中有重复值或target-num=num的情况