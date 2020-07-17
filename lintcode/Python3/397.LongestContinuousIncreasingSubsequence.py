# https://www.lintcode.com/problem/longest-continuous-increasing-subsequence/description?_from=ladder&&fromId=1
class Solution:
    """
    @param A: An array of Integer
    @return: an integer
    """
    def longestIncreasingContinuousSubsequence(self, A):
        if not A:
            return 0
        longest, incr, desc = 1, 1, 1
        for i in range(1, len(A)):
            if A[i] > A[i - 1]:
                incr += 1
                desc = 1
            elif A[i] < A[i - 1]:
                incr = 1
                desc += 1
            else:
                incr = 1
                desc = 1
            longest = max(longest, max(incr, desc))
            
        return longest