#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-17 10:07:44
@LastEditor: John
@LastEditTime: 2020-07-17 10:09:03
@Discription: 
@Environment: python 3.7.7
'''
# tag: 二进制
'''直接定义一个mask每次左移并与n比对，如果不为1说明有一个1，由于n是无符号整型，所以总共32位'''
class Solution:
    def hammingWeight(self, n: int) -> int:
        bits = 0
        mask = 1
        for i in range(32):
            if n & mask != 0:
                bits+=1
            mask <<= 1
        return bits
'''利用n &= (n - 1)会把n的最后一个1变成0，其他不变'''
class Solution:
    def hammingWeight(self, n: int) -> int:
        ans = 0
        while n:
            n &= (n - 1)
            ans += 1
        return ans