#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-18 08:34:18
@LastEditor: John
@LastEditTime: 2020-07-18 08:35:24
@Discription: 
@Environment: python 3.7.7
'''
class Solution:
    '''动态规划+最高有效位
    '''
    def countBits(self, num: int) -> List[int]:
        ans = [0]*(num+1)
        # generate ans for [0,b)
        i = 0
        b = 1
        ans[0] = 0
        while b <= num:
            # generate [b,2b) or [b,num] for [0,b] 
            while i<b and i+b<=num:
                ans[i+b]= ans[i]+1
                i+=1
            i=0 # reset i
            b <<= 1
        return ans