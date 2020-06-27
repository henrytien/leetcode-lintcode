# https://leetcode.com/problems/climbing-stairs/


class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 2:
            return n
        f1, f2, f3 = 1, 2, 3
        for i in range(3, n+1):
            f3 = f2 + f1
            f1 = f2
            f2 = f3
        return f3


if __name__ == '__main__':
    Solution().climbStairs(4)
