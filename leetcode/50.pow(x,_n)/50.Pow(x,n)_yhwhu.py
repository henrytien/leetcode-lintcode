    # Source : https://leetcode.com/problems/powx-n/
# Author : yhwhu
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
    def myPow(self, x: float, n: int) -> float:
        def quickMul(N):
            if N == 0:
                return 1.0
            y = quickMul(N // 2)
            return y * y if N % 2 == 0 else y * y * x

        return quickMul(n) if n >= 0 else 1.0 / quickMul(-n)

