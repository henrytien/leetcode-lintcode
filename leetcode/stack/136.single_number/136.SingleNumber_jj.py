#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-17 09:40:23
@LastEditor: John
@LastEditTime: 2020-07-17 09:41:21
@Discription: 
@Environment: python 3.7.7
'''
'''
利用异或的性质，即0^a=a, a^b^b==b^a^b=a
'''
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        return reduce(lambda x,y:x ^ y, nums) # reduce方法