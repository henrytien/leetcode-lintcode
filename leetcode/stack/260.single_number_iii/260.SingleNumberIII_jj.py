#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-16 14:10:53
@LastEditor: John
@LastEditTime: 2020-07-16 14:14:47
@Discription: 
@Environment: python 3.7.7
'''
'''
参考(https://leetcode-cn.com/problems/single-number/)
先进行一轮异或得到x^y=bitmask，x,y都是只出现一次的项，
然后使用diff分离，原理是异或后的为1的bit只可能来自x或者y中的一个，而不是同时
'''
class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        bitmask = 0
        for num in nums:
            bitmask ^= num
        diff = bitmask & (-bitmask)
        x = 0
        for num in nums:
            if num & diff:
                x ^= num
        return [x, bitmask^x]