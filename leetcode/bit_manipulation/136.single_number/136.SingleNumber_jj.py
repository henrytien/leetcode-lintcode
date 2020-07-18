#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-18 14:42:03
@LastEditor: John
@LastEditTime: 2020-07-18 18:15:48
@Discription: 
@Environment: python 3.7.7
'''
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda x,y:x ^ y, nums) # reduce方法