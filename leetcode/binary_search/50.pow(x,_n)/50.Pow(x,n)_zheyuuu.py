# Source : https://leetcode.com/problems/powx-n/submissions/
# Author : zheyuuu
# Date   : 2020-07-26

##################################################################################################### 
#
# Implement pow(x, n), which calculates x raised to the power n (xn).
# 
# Example 1:
# 
# Input: 2.00000, 10
# Output: 1024.00000
# 
# Example 2:
# 
# Input: 2.10000, 3
# Output: 9.26100
# 
# Example 3:
# 
# Input: 2.00000, -2
# Output: 0.25000
# Explanation: 2-2 = 1/22 = 1/4 = 0.25
# 
# Note:
# 
# 	-100.0 < x < 100.0
# 	n is a 32-bit signed integer, within the range [&minus;231, 231 &minus; 1]
# 
#####################################################################################################

class Solution:
    # Recursion
    # O(32)
    def myPow(self, x: float, n: int) -> float:
        if n==0:
            return 1
        if n<0:
            n = -n
            x = 1/x
        if n%2==0:
            return self.myPow(x*x, n>>1)
        else:
            return x*self.myPow(x*x, n>>1)
    # Iteration
    # O(32)
    def myPow(self, x, n):
        if n<0:
            n = -n
            x = 1/x
        ans = 1
        while(n):
            if n%2==1:
                ans *= x
            else:
                ans = ans
            x = x*x
            n = n >>1
        return ans