#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-25 10:11:17
@LastEditor: John
@LastEditTime: 2020-07-25 10:30:29
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/climbing-stairs/
# Author : JohnJim0816
# Date   : 2020-07-25

##################################################################################################### 
#
# You are climbing a stair case. It takes n steps to reach to the top.
# 
# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
# 
# Example 1:
# 
# Input: 2
# Output: 2
# Explanation: There are two ways to climb to the top.
# 1. 1 step + 1 step
# 2. 2 steps
# 
# Example 2:
# 
# Input: 3
# Output: 3
# Explanation: There are three ways to climb to the top.
# 1. 1 step + 1 step + 1 step
# 2. 1 step + 2 steps
# 3. 2 steps + 1 step
# 
# Constraints:
# 
# 	1 <= n <= 45
#####################################################################################################

class Solution:
    '''递归的同时，用数组记忆之前得到的结果
    '''
    def climbStairs(self, n: int) -> int:
        memo=[0]*(n+1)
        return self.climb_stairs(0,n, memo)
    def climb_stairs(self,i,n,memo):
        if i > n:
            return 0
        if i == n:
            return 1
        if memo[i] > 0:
            return memo[i]
        memo[i]=self.climb_stairs(i + 1, n,memo) + self.climb_stairs(i + 2, n,memo)
        return memo[i]

class Solution:
    ''' 直接DP，新建一个字典或者数组来存储以前的变量，空间复杂度O(n)
    '''
    def climbStairs(self, n: int) -> int:
        dp = [0]*(n+2) # 或dp={}
        dp[1] = 1
        dp[2] = 2
        for i in range(3,n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]

class Solution:
    ''' 还是DP，只不过是只存储前两个元素，减少了空间，空间复杂度O(1)
    '''
    def climbStairs(self, n: int) -> int:
        if n==1 or n==2: return n
        a, b, temp = 1, 2, 0
        for i in range(3,n+1):
            temp = a + b
            a = b
            b = temp
        return temp

class Solution:
    '''通项公式
    '''
    def climbStairs(self, n: int) -> int:
        import math
        sqrt5=5**0.5
        fibin=math.pow((1+sqrt5)/2,n+1)-math.pow((1-sqrt5)/2,n+1)
        return int(fibin/sqrt5)


class Solution:
    '''矩阵快速幂
    '''
    pass